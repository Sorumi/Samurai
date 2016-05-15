package model;

import model.po.*;

import java.io.*;
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
    private InformationLibrary informationLibrary;
    private PropsStore propsStore;

    private int money;

    private static int fileNum;

    private Date time;

    private StoryModel(){
        gameModel = new GameModel();

        this.money = 0;

        this.armory = new Armory();
        this.armory.initialize();

        this.materialLibrary = new MaterialLibrary();

        this.informationLibrary = new InformationLibrary();
        this.informationLibrary.initialize();

        this.propsStore = new PropsStore();

        this.samuraiPO_1 = new SamuraiPO(1,0,this.armory.getWeapon(11),14,gameModel.getChessBoardModel(),this.armory.getArmor(911),new Position(3,12),30,1);
        this.samuraiPO_2 = new SamuraiPO(2,0,this.armory.getWeapon(111),14,gameModel.getChessBoardModel(),this.armory.getArmor(911),new Position(7,0),30,1);
        this.samuraiPO_3 = new SamuraiPO(3,0,this.armory.getWeapon(211),14,gameModel.getChessBoardModel(),this.armory.getArmor(911),new Position(14,0),30,1);

        this.time = new Date();
    }

    public Date getTime(){
        return this.time;
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

    public SamuraiPO[] getSamuraiPOs(){
        return new SamuraiPO[]{null,samuraiPO_1,samuraiPO_2,samuraiPO_3};
    }

    public SamuraiPO getSamuraiPO(int i) {
        switch (i) {
            case 1:
                return samuraiPO_1;
            case 2:
                return samuraiPO_2;
            case 3:
                return samuraiPO_3;
            default:
                return null;
        }
    }

    public PropsStore getPropsStore() {
        return propsStore;
    }

    public Armory getArmory(){
        return this.armory;
    }

    public MaterialLibrary getMaterialLibrary(){
        return this.materialLibrary;
    }

    public InformationLibrary getInformationLibrary() {
        return this.informationLibrary;
    }

    //用序列化保存storyModel的对象
    public void saveStoryModel(int num){
        try {
            this.time = new Date();

            String fileName = "Samurai_StoryModel_" + num + ".ser";
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();

            System.out.println("save successfully");
        }catch (Exception e){
            System.out.println("save failed");
        }
    }

    //用序列化读取整个StoryModel
    public static StoryModel loadStoryModel(int num){
        try{
            fileNum = num;

            String fileName = "Samurai_StoryModel_" + num + ".ser";
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object thisObject = objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("load successfully : " + StoryModel.fileNum);

            return (StoryModel) thisObject;
        }catch (Exception e){
            System.out.println("load failed");
        }
        return new StoryModel();
    }

    public static Date getTimeOfNum(int num){
        try{
            String fileName = "Samurai_StoryModel_" + num + ".ser";
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object thisObject = objectInputStream.readObject();
            objectInputStream.close();

            StoryModel s = (StoryModel) thisObject;

            return s.getTime();
        }catch (Exception e){

        }
        return null;
    }

    public static void setStoryModel(StoryModel sModel){
        storyModel.armory = sModel.armory;
        storyModel.materialLibrary = sModel.materialLibrary;
        storyModel.informationLibrary = sModel.informationLibrary;
        storyModel.propsStore = sModel.propsStore;
        storyModel.samuraiPO_1 = sModel.samuraiPO_1;
        storyModel.samuraiPO_2 = sModel.samuraiPO_2;
        storyModel.samuraiPO_3 = sModel.samuraiPO_3;
        storyModel.time = sModel.time;
        storyModel.money = sModel.money;
    }

    //单例模式用于取唯一的storyModel
    public static StoryModel getStoryModel(){
        if(storyModel == null){
            storyModel = loadStoryModel(0);
        }
        setStoryModel(storyModel);
        return storyModel;
    }

}
