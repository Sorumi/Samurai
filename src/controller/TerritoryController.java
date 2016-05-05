package controller;

import model.StoryModel;

/**
 * Created by Kray on 16/5/5.
 */
public class TerritoryController {

    private StoryModel storyModel;

    public void setStoryModel(StoryModel storyModel){
        this.storyModel = storyModel;
    }

    public void save(){
        this.storyModel.saveStoryModel();
    }
}
