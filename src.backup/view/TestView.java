package view;

import model.BaseModel;
import model.UpdateMessage;

public class TestView extends BaseModel{
	
	public void test(){

		DisplayBlock testBlock = new DisplayBlock(3,2);
		testBlock.setState(3);
        super.updateChange(new UpdateMessage("block",testBlock));
        
	}

}
