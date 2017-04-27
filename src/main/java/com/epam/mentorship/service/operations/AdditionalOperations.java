package com.epam.mentorship.service.operations;

import com.epam.mentorship.service.model.PostModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Uliana Pizhanska on 28/04/2017.
 */
public class AdditionalOperations {
    private static PostModel[] postModels;
    private static FileReader fileReader;
    private static BufferedReader bufferedReader;

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
            fileReader = new FileReader("src/main/resources/posts.txt");
        }
        catch (FileNotFoundException e){

        }
        bufferedReader = new BufferedReader(fileReader);
        String line= "";
        String[] arrs=null;
        int num=0;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                arrs = line.split(",");
                postModels[num] = new PostModel(Integer.parseInt(arrs[0]),Integer.parseInt(arrs[1]),arrs[2], arrs[3]);
                num++;
            }
        }
        catch (IOException e){

        }
        return postModels;
    }
}
