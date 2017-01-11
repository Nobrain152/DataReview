package ui.credit;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.userbl.CustomerInfoManagementController;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.UILaunch;
import ui.UIhelper;
import vo.CreditVO;

public class creditCheckViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private CustomerInfoManagementController creditManage;
	
	@FXML
	private Label credit;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_home;
	
	
	@FXML
	private TableView<creditItem> tv_credit;
	@FXML
	private TableColumn<?, ?> tc_ID;
	@FXML
	private TableColumn<?, ?> tc_time;
	@FXML
	private TableColumn<?, ?> tc_action;
	@FXML
	private TableColumn<?, ?> tc_change;
	@FXML
	private TableColumn<?, ?> tc_result;
	private ObservableList<creditItem> data;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_homeAction(ActionEvent ev) throws Exception {
		application.gotocustomerGuide();
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev) throws Exception {
		application.gotocustomerInfo();
	}
	
	
	@Override
	public void initialize(URL url,ResourceBundle rb){
		helper=UIhelper.getInstance();
		creditManage=new CustomerInfoManagementController();
		
		
		ArrayList<CreditVO> creditList=creditManage.individualCredictRecord(helper.getUserID());
		int size=creditList.size();
		ArrayList<creditItem> dataList=new ArrayList<creditItem>();
		for(int i=0;i<size;i++){
			CreditVO tempCreditVO=creditList.get(i);			
			dataList.add(new creditItem(tempCreditVO.getOrderID(),tempCreditVO.getTime(),tempCreditVO.getAction().toString(),tempCreditVO.getCreditChange(),tempCreditVO.getCreditResult()));
		}
		data = FXCollections.observableArrayList(dataList);
		
		tc_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		tc_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		tc_action.setCellValueFactory(new PropertyValueFactory<>("action"));
		tc_change.setCellValueFactory(new PropertyValueFactory<>("change"));
		tc_result.setCellValueFactory(new PropertyValueFactory<>("result"));
		tv_credit.setItems(data);
		
		CreditVO tempCreditVO=creditList.get(size-1);
		int cr=tempCreditVO.getCreditResult();
		credit.setText(String.valueOf(cr));
	}
	
	public static class creditItem{
		private SimpleStringProperty ID;
		private SimpleStringProperty time;
		private SimpleStringProperty action;
		private SimpleStringProperty change;
		private SimpleIntegerProperty result;
		
		private creditItem(String ID,String time,String action,String change, int result){
			this.ID=new SimpleStringProperty(ID);
			this.time=new SimpleStringProperty(time);
			this.action=new SimpleStringProperty(action);
			this.change=new SimpleStringProperty(change);
			this.result=new SimpleIntegerProperty(result);
		}
		
		public String getID() {
			return ID.get();
		}

		public void setID(String str) {
			ID.set(str);
		}
		
		public String getTime() {
			return time.get();
		}

		public void setTime(String str) {
			time.set(str);
		}
		
		public String getAction() {
			return action.get();
		}

		public void setAction(String str) {
			action.set(str);
		}
		
		public String getChange() {
			return change.get();
		}

		public void setChange(String str) {
			change.set(str);
		}
		
		public int getResult(){
			return result.get();
		}
		
		public void setResult(int n){
			result.set(n);
		}
	}

}
