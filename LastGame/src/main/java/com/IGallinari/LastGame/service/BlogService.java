package com.IGallinari.LastGame.service;

import com.IGallinari.LastGame.entity.*;
import com.IGallinari.LastGame.entity.id_class.IdParagraph;
import com.IGallinari.LastGame.entity.id_class.idTagPlayer;
import com.IGallinari.LastGame.entity.id_class.idTagTeam;
import com.IGallinari.LastGame.payload.request.TokenRequest;
import com.IGallinari.LastGame.payload.request.blog.CreateBlogRequest;
import com.IGallinari.LastGame.payload.request.blog.paragraph.ViewParagraphRequest;
import com.IGallinari.LastGame.payload.response.blog.*;
import com.IGallinari.LastGame.payload.response.blog.paragraph.ViewParagraphResponse;
import com.IGallinari.LastGame.payload.response.blog.paragraph.tagPlayer.ViewTagPlayer;
import com.IGallinari.LastGame.payload.response.blog.paragraph.tagTeam.ViewTagTeam;
import com.IGallinari.LastGame.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * Service class for managing blog-related operations.
 * This includes creating and retrieving blogs, paragraphs, and tags for players and teams.
 */
@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    private final JwtService jwtService;

    private final UserRepository userRepository;

    private final ParagraphRepository paragraphRepository;
    
    private final TagPlayerRepository tagPlayerRepository;

    private final TagTeamRepository tagTeamRepository;

    private final FavPlayerRepository favPlayerRepository;

    private final FavTeamRepository favTeamRepository;

    private final PlayerRepository playerRepository;

    private final TeamRepository teamRepository;
    /**
     * Saves a blog based on the provided request data.
     *
     * @param createBlogRequest Request data for creating a blog.
     * @return Response indicating success or failure of blog creation.
     */
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
                    idTagPlayer idTagPlayer = new idTagPlayer();
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
                    idTagTeam idTagTeam = new idTagTeam();
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
    /**
     * Retrieves a blog by its ID.
     *
     * @param tokenRequest Token request to validate user access.
     * @param idBlog The ID of the blog to retrieve.
     * @return The response containing blog details.
     */
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
        List<ViewTagPlayer> tagPlayerList = builTagPlayerList(idBlog);
        List<ViewTagTeam> tagTeamsList = buildTagTeamList(idBlog);
        User user = blog.getUser();
        return new BlogResponse(
                logged,
                user.getEmail(),
                blog.getTitle(),
                blog.getSubtitle(),
                blog.getImg(),
                blog.getDate(),
                viewParagraphResponseList,
                tagPlayerList,
                tagTeamsList
        );
    }
    /**
     * Builds a list of tagged players for a given blog.
     *
     * @param idBlog The ID of the blog for which to retrieve tagged players.
     * @return A list of tagged players.
     */
    private List<ViewTagPlayer> builTagPlayerList(int idBlog){
        List<Integer> tagIdPlayersList = tagPlayerRepository.findTagPlayerByIdBlog(idBlog);
        List<ViewTagPlayer> tagPlayerList = new ArrayList<>();
        for (int idPlayer: tagIdPlayersList){
            Player player = playerRepository.findById(idPlayer);
            tagPlayerList.add(new ViewTagPlayer(
                    player.getId(),
                    player.getFirstname(),
                    player.getLastname()
            ));
        }
        return tagPlayerList;
    }
    /**
     * Builds a list of tagged teams for a given blog.
     *
     * @param idBlog The ID of the blog for which to retrieve tagged teams.
     * @return A list of tagged teams.
     */
    private List<ViewTagTeam> buildTagTeamList(int idBlog){
        List<Integer> tagIdTeamsList = tagTeamRepository.findTagTeamByIdBlog(idBlog);
        List<ViewTagTeam> tagTeamsList = new ArrayList<>();
        for (int idTeam: tagIdTeamsList){
            Team team = teamRepository.findById(idTeam);
            tagTeamsList.add(new ViewTagTeam(
                    team.getId(),
                    team.getName(),
                    team.getNickname(),
                    team.getCode(),
                    team.getLogo()
            ));
        }
        return tagTeamsList;
    }
    /**
     * Retrieves a list of blogs, considering user interests and access permissions.
     *
     * @param tokenRequest Token request to validate user access.
     * @return ResponseEntity containing a list of blogs.
     */
    public ResponseEntity<?> getAllBlogs(TokenRequest tokenRequest){
        String token = tokenRequest.getToken();
        List<Blog> blogs = blogRepository.findAll();
        blogs.sort(Comparator.comparing(Blog::getDate).reversed());
        boolean logged = jwtService.isTokenValid(token);
        List<ViewBlog> viewBlogList = new ArrayList<>();
        if(!logged){
            for(Blog blog: blogs){
                int idBlog = blog.getId();
                List<ViewTagPlayer> tagPlayerList = builTagPlayerList(idBlog);
                List<ViewTagTeam> tagTeamsList = buildTagTeamList(idBlog);
                viewBlogList.add(new ViewBlog(
                        blog.getId(),
                        blog.getTitle(),
                        blog.getSubtitle(),
                        blog.getImg(),
                        blog.getDate(),
                        tagPlayerList,
                        tagTeamsList
                ));
            }
            return ResponseEntity.ok(new AllBlogUnLoggedResponse(false,viewBlogList));
        }else{
            List<ViewBlog> blogsAboutUserInterests = new ArrayList<>();
            int idUser = jwtService.getIdUser(token);
            for(Blog blog: blogs){
                int idBlog = blog.getId();
                List<Integer> tagIdPlayersList = tagPlayerRepository.findTagPlayerByIdBlog(idBlog);
                List<Integer> tagIdTeamsList = tagTeamRepository.findTagTeamByIdBlog(idBlog);
                List<Integer> favIdPlayers = favPlayerRepository.findFavPlayersByUser(idUser);
                List<Integer> favIdTeams = favTeamRepository.findFavTeamsByUser(idUser);
                List<ViewTagPlayer> tagPlayerList = builTagPlayerList(idBlog);
                List<ViewTagTeam> tagTeamsList = buildTagTeamList(idBlog);
                if(favIdPlayers.stream().anyMatch(tagIdPlayersList::contains) || favIdTeams.stream().anyMatch(tagIdTeamsList::contains)){
                    blogsAboutUserInterests.add(new ViewBlog(
                            blog.getId(),
                            blog.getTitle(),
                            blog.getSubtitle(),
                            blog.getImg(),
                            blog.getDate(),
                            tagPlayerList,
                            tagTeamsList
                            )
                    );
                }else{
                    viewBlogList.add(new ViewBlog(
                            blog.getId(),
                            blog.getTitle(),
                            blog.getSubtitle(),
                            blog.getImg(),
                            blog.getDate(),
                            tagPlayerList,
                            tagTeamsList
                    ));
                }
            }
            return ResponseEntity.ok(new AllBlogLoggedResponse(true,blogsAboutUserInterests,viewBlogList));
        }
    }

}
