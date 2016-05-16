package controller;

import model.StoryModel;
import model.po.*;

import java.util.ArrayList;

/**
 * Created by Kray on 16/5/6.
 */
public class StoreController extends TerritoryController {

    private ArrayList<Material> materials;
    private ArrayList<Props> props;
    private PropsStore propsStore;

    public void getAllMaterial() {
        MaterialLibrary materialLibrary = storyModel.getMaterialLibrary();
        this.materials = materialLibrary.checkAll();
    }

    public void getAllProps(){
        PropsStore propsStore = storyModel.getPropsStore();
        for (int i = 1; i <= 14; i++) {
            if(propsStore.getProps(i).getNumber() != 0){
                props.add(propsStore.getProps(i));
            }
        }
    }

    public void updateMoney(int delta){
        this.propsStore.updateMoney(delta);
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setPropsStore() {
        this.propsStore = StoryModel.getStoryModel().getPropsStore();
    }

    public PropsStore getPropsStore() {
        return propsStore;
    }

    public MaterialLibrary getMaterialLibrary(){
        return StoryModel.getStoryModel().getMaterialLibrary();
    }

    public Information getInformationOfTag(int tag){
        return storyModel.getInformationLibrary().getInformationOfTag(tag);
    }
}
