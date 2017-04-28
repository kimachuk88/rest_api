package com.epam.mentorship.service.operations;

import com.epam.mentorship.service.model.PostModel;
import org.apache.commons.io.FileUtils;
import org.apache.velocity.texen.util.FileUtil;

import java.io.*;
import java.util.ArrayList;
import org.apache.commons.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Uliana Pizhanska on 28/04/2017.
 */
public class AdditionalOperations {
    private static PostModel[] postModels;
    private static List<String> list;

    public List<Integer> postId(PostModel[] postModels) {
        List<Integer> id = new ArrayList<>();
        for (PostModel post : postModels) {
            id.add(post.getId());
        }
        return id;
    }

    public int countNonNullObj(PostModel[] postModels){
        return (int) Arrays.stream(postModels).filter(Objects::nonNull).count();
    }

    public static PostModel[] readFromFile(){
        try {
            list = FileUtils.readLines(new File("src/main/resources/posts.txt"));
        }
        catch (IOException e){

        }
        String[] lines = list.toArray(new String[list.size()]);
        postModels = new PostModel[lines.length];
        for(int i = 0; i < lines.length; i++) {
            postModels[i] = new PostModel(lines[i]);
        }

        return postModels;
    }
}
