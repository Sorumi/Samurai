package view;

import model.po.ActualBlock;
import model.BaseModel;
import model.UpdateMessage;

public class TestView extends BaseModel{
	
	public void test(){

		ActualBlock testBlock = new ActualBlock(3,2);
		testBlock.setState(3);
        super.updateChange(new UpdateMessage("block",testBlock));
        
	}

}
