package model;

import main.Main;
import model.po.*;

import java.io.Serializable;

/**
 * Created by Kray on 16/4/22.
 */
public class StoryModel implements Serializable{

    private static final long serialVersionUID = 1L;
    private SamuraiPO samuraiPO_1;
    private SamuraiPO samuraiPO_2;
    private SamuraiPO samuraiPO_3;
    private GameModel gameModel;
    private Armory armory;
    private MaterialLibrary materialLibrary;
    //只要有一个gamemodel就好啦

    //考虑是否要写成单例?
    public StoryModel(){

        getStoryModel();

        this.armory = new Armory();
        this.armory.initialize();

        this.materialLibrary = new MaterialLibrary();

        this.samuraiPO_1 = new SamuraiPO(0,0,this.armory.getWeapon(11),gameModel.getLength(),gameModel.getChessBoardModel(),new Armor());
        this.samuraiPO_2 = new SamuraiPO(1,0,this.armory.getWeapon(111),gameModel.getLength(),gameModel.getChessBoardModel(),new Armor());
        this.samuraiPO_3 = new SamuraiPO(2,0,this.armory.getWeapon(211),gameModel.getLength(),gameModel.getChessBoardModel(),new Armor());

    }

    public void startLevel(int level){
        switch (level){
            case 1:
//                gameModel = new GameModel();
                break;
            default:
                break;
        }
    }

    public void changeWeapon(int samuraiNum, int weaponNum){
        switch (samuraiNum){
            case 1:
                this.samuraiPO_1.changeWeapon(this.armory.getWeapon(weaponNum));
                break;
            case 2:
                this.samuraiPO_2.changeWeapon(this.armory.getWeapon(weaponNum));
                break;
            case 3:
                this.samuraiPO_3.changeWeapon(this.armory.getWeapon(weaponNum));
                break;
            default:
                break;
        }
    }

    public void createWeapon(){

    }

    public Armory getArmory(){
        return this.armory;
    }

    public MaterialLibrary materialLibrary(){
        return this.materialLibrary;
    }

    //用序列化保存整个StoryModel
    public void save(){

    }

    //用序列化读取整个StoryModel
    public static StoryModel getStoryModel(){
//        if(){
//            如果没有就 new 一个

//        }else{
//            如果有了就读一个
//        }
        return new StoryModel();
    }

}
