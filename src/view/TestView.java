package view;

import model.po.DisplayBlock;
import model.BaseModel;
import model.UpdateMessage;

public class TestView extends BaseModel{
	
	public void test(){

        super.updateChange(new UpdateMessage("block",new DisplayBlock(3,2)));
        
	}

}
