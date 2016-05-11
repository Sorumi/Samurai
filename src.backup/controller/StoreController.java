package controller;

import model.po.Information;
import model.po.Material;
import model.po.MaterialLibrary;

import java.util.ArrayList;

/**
 * Created by Kray on 16/5/6.
 */
public class StoreController extends TerritoryController {

    private ArrayList<Material> materials;

    public void getAllMaterial() {
        MaterialLibrary materialLibrary = storyModel.getMaterialLibrary();
        this.materials = materialLibrary.checkAll();
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public Information getInformationOfTag(int tag){
        return storyModel.getInformationLibrary().getInformationOfTag(tag);
    }
}
