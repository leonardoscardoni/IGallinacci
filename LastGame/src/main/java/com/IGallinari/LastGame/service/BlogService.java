package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.*;
import com.IGallinari.LastGame.entity.id_class.IdParagraph;
import com.IGallinari.LastGame.entity.id_class.IdTagPlayer;
import com.IGallinari.LastGame.entity.id_class.IdTagTeam;
import com.IGallinari.LastGame.payload.request.TokenRequest;
import com.IGallinari.LastGame.payload.request.blog.BlogRequest;
import com.IGallinari.LastGame.payload.request.blog.CreateBlogRequest;
import com.IGallinari.LastGame.payload.request.blog.paragraph.ViewParagraphRequest;
import com.IGallinari.LastGame.payload.response.blog.BlogResponse;
import com.IGallinari.LastGame.payload.response.blog.CreateBlogResponse;
import com.IGallinari.LastGame.payload.response.blog.paragraph.ViewParagraphResponse;
import com.IGallinari.LastGame.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    private final JwtService jwtService;

    private final UserRepository userRepository;

    private final ParagraphRepository paragraphRepository;
    
    private final TagPlayerRepository tagPlayerRepository;

    private final TagTeamRepository tagTeamRepository;

    public CreateBlogResponse saveBlog(CreateBlogRequest createBlogRequest){
        String token = createBlogRequest.getToken();
        if(jwtService.isTokenValid(token) && jwtService.getRole(token)==1) {
            User user = userRepository.findById(jwtService.getIdUser(token));
            Blog blog = new Blog();
            try {
                blog.setUser(user);
                blog.setTitle(createBlogRequest.getTitle());
                blog.setSubtitle(createBlogRequest.getSubTitle());
                blog.setDate(createBlogRequest.getDate());
                blog.setImg(createBlogRequest.getImg());
                blogRepository.save(blog);
            }catch (Exception e){
                return new CreateBlogResponse(false,"Not able to create the Blog");
            }
            try {
                List<ViewParagraphRequest> viewParagraphRequests = createBlogRequest.getParagraphs();
                int i = 0;
                for (ViewParagraphRequest viewParagraphRequest : viewParagraphRequests){
                    i+=1;
                    Paragraph paragraph = new Paragraph();
                    IdParagraph idParagraph = new IdParagraph();
                    idParagraph.setIdBlog(blog.getId());
                    idParagraph.setNumber(i);
                    paragraph.setIdParagraph(idParagraph);
                    paragraph.setTitle(viewParagraphRequest.getTitle());
                    paragraph.setContent(viewParagraphRequest.getContent());
                    paragraphRepository.save(paragraph);
                }
            }catch (Exception e){
                return new CreateBlogResponse(false,"Not able to create the Paragraphs");
            }
            try {
                int[] tagPlayers = createBlogRequest.getTagPlayer();
                for (int idPlayer: tagPlayers){
                    TagPlayer tagPlayer = new TagPlayer();
                    IdTagPlayer idTagPlayer = new IdTagPlayer();
                    idTagPlayer.setIdBlog(blog.getId());
                    idTagPlayer.setIdPlayer(idPlayer);
                    tagPlayer.setIdTagPlayer(idTagPlayer);
                    tagPlayerRepository.save(tagPlayer);
                }
            }catch (Exception e){
                return new CreateBlogResponse(false,"Not able to tag the Player");
            }
            try {
                int[] tagTeams = createBlogRequest.getTagTeam();
                for (int idTeam: tagTeams){
                    TagTeam tagTeam = new TagTeam();
                    IdTagTeam idTagTeam = new IdTagTeam();
                    idTagTeam.setIdBlog(blog.getId());
                    idTagTeam.setIdTeam(idTeam);
                    tagTeam.setIdTagTeam(idTagTeam);
                    tagTeamRepository.save(tagTeam);
                }
            }catch (Exception e){
                return new CreateBlogResponse(false,"Not able to tag the Team");
            }
            return new CreateBlogResponse(true,"Blog created successfully");
        }
        return new CreateBlogResponse(false,"The user does not have the necessary role to create a Blog");
    }

    public BlogResponse getBlog(TokenRequest tokenRequest, int idBlog){
        String token = tokenRequest.getToken();
        Blog blog = blogRepository.findBlogById(idBlog);
        boolean logged = jwtService.isTokenValid(token);
        int nParagraphsAllawed=1;
        List<Paragraph> paragraphs = paragraphRepository.findParagraphByBlogOrderByNumber(blog);
        if(logged){
            nParagraphsAllawed = paragraphs.size();
        }
        List<ViewParagraphResponse> viewParagraphResponseList = new ArrayList<>();
        for (int i = 0; i < nParagraphsAllawed; i++) {
            Paragraph paragraph = paragraphs.get(i);
            viewParagraphResponseList.add( new ViewParagraphResponse(
                    paragraph.getTitle(),
                    paragraph.getContent()
                    )
            );
        }
        List<Integer> tagPlayersList = tagPlayerRepository.findTagPlayerByIdBlog(idBlog);
        int[] tagPlayersArray = tagPlayersList.stream().mapToInt(Integer::intValue).toArray();
        List<Integer> tagTeamsList = tagTeamRepository.findTagTeamByIdBlog(idBlog);
        int[] tagTeamsArray = tagTeamsList.stream().mapToInt(i -> i).toArray();
        User user = userRepository.findById(jwtService.getIdUser(token));
        return new BlogResponse(
                logged,
                user.getEmail(),
                blog.getTitle(),
                blog.getSubtitle(),
                blog.getImg(),
                blog.getDate(),
                viewParagraphResponseList,
                tagPlayersArray,
                tagTeamsArray
        );
    }

}
