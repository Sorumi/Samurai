package controller;

import model.po.Information;
import model.po.Props;
import model.po.PropsStore;

import java.util.ArrayList;

/**
 * Created by Kray on 16/5/15.
 */
public class ShopController extends TerritoryController {

    private PropsStore propsStore;

    public void setPropsStore() {
        this.propsStore = storyModel.getPropsStore();
    }

    public PropsStore getPropsStore() {
        return this.propsStore;
    }

    public void updateMoney(int delta){
        this.propsStore.updateMoney(delta);
    }

    public Information getInformationOfTag(int tag){
        return storyModel.getInformationLibrary().getInformationOfTag(tag);
    }

}
