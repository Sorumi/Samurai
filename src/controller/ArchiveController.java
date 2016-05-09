package controller;

import model.StoryModel;

import java.util.Date;

/**
 * Created by Kray on 16/5/8.
 */
public class ArchiveController extends TerritoryController {

    public void load(int n){
        StoryModel.loadStoryModel(n);
    }

    public Date getTime(int num){
        try{
            return StoryModel.getTimeOfNum(num);
        }catch (NullPointerException e){
            System.out.println("File " + num + " not Found.");
            return null;
        }
    }

}
