package controller;

import model.po.Props;
import model.po.PropsStore;

import java.util.ArrayList;

/**
 * Created by Kray on 16/5/15.
 */
public class ShopController extends TerritoryController {

    private int money;
    private PropsStore propsStore;

    public void setPropsStore() {
        this.propsStore = storyModel.getPropsStore();
    }

    public PropsStore getPropsStore() {
        return propsStore;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void updateMoney(int delta){
        this.money += delta;
    }
}
