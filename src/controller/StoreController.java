package controller;

import model.po.Material;
import model.po.MaterialLibrary;

import java.util.ArrayList;

/**
 * Created by Kray on 16/5/6.
 */
public class StoreController extends TerritoryController {

    public ArrayList<Material> getAllMaterial() {
        MaterialLibrary materialLibrary = storyModel.getMaterialLibrary();
        return materialLibrary.checkAll();
    }

}
