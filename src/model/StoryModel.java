package model;

import main.Main;
import model.po.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kray on 16/4/22.
 */
public class StoryModel implements Serializable{

    private static StoryModel storyModel;

    private static final long serialVersionUID = 1L;
    private SamuraiPO samuraiPO_1;
    private SamuraiPO samuraiPO_2;
    private SamuraiPO samuraiPO_3;
    private transient GameModel gameModel;
    private Armory armory;
    private MaterialLibrary materialLibrary;

    //用来测试有没有序列化成功 不用管它
    private Date time;

    private StoryModel(){
        gameModel = new GameModel();

        this.armory = new Armory();
        this.armory.initialize();

        this.materialLibrary = new MaterialLibrary();

        this.samuraiPO_1 = new SamuraiPO(0,0,this.armory.getWeapon(11),gameModel.getLength(),gameModel.getChessBoardModel(),new Armor());
        this.samuraiPO_2 = new SamuraiPO(1,0,this.armory.getWeapon(111),gameModel.getLength(),gameModel.getChessBoardModel(),new Armor());
        this.samuraiPO_3 = new SamuraiPO(2,0,this.armory.getWeapon(211),gameModel.getLength(),gameModel.getChessBoardModel(),new Armor());

        this.time = new Date();
    }

    public Date getTime(){
        return this.time;
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
        System.out.println("Samurai " + samuraiNum + " is changing to weapon " + weaponNum);
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

    public MaterialLibrary getMaterialLibrary(){
        return this.materialLibrary;
    }

    //用序列化保存storyModel的对象
    public void saveStoryModel(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Samurai_StoryModel.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);

            this.time = new Date();
            System.out.println(this.time.toString());

            objectOutputStream.close();

            System.out.println("save successfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //用序列化读取整个StoryModel
    public static StoryModel loadStoryModel(){
        try{
            FileInputStream fileInputStream = new FileInputStream("Samurai_StoryModel.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object thisObject = objectInputStream.readObject();
            objectInputStream.close();

            StoryModel s = (StoryModel) thisObject;
            System.out.println(s.getTime());
            System.out.println("load successfully");

            return (StoryModel) thisObject;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new StoryModel();
    }

    //单例模式用于取唯一的storyModel
    public static StoryModel getStoryModel(){
        if(storyModel == null){
            storyModel = StoryModel.loadStoryModel();
        }
        return storyModel;
    }

}
