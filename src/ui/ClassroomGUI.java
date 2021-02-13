package ui;


import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import model.Classroom;
import model.UserAccount;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class ClassroomGUI {

	@FXML
    private BorderPane mainPanel;
    
    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lbInfo;

    @FXML
    private TextField txtGender;

    @FXML
    private TextField txtCareer;

    @FXML
    private TextField txtBirthday;

    @FXML
    private TextField txtBrowser;
    
    @FXML
    private TableView<UserAccount> tvUserList;
    
    @FXML
    private TableColumn<UserAccount, String> tcUsername;

    @FXML
    private TableColumn<UserAccount, String> tcGender;

    @FXML
    private TableColumn<UserAccount, String> tcCareer;

    @FXML
    private TableColumn<UserAccount, String> tcBirthday;

    @FXML
    private TableColumn<UserAccount, String> tcBrowser;
    	

    
    
    private Classroom classroom;
    
    public ClassroomGUI(Classroom cm) {
    	
    	classroom = cm;    	
	}
    
    
    private void initializeTableView() {
    	ObservableList<UserAccount> observableList;
    	observableList = FXCollections.observableArrayList(classroom.getUsers());
    	
		tvUserList.setItems(observableList);
		tcUsername.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("name")); //the tableview search for a method called getName
		tcGender.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("gender")); //the tableview search for a method called getEmail
		tcCareer.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("career"));//the tableview search for a method called getCareer
		tcBirthday.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("birthday"));//the tableview search for a method called getBirthday
		tcBrowser.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("browser"));//the tableview search for a method called getBrowser
		
    }
    
       
    /**
     * This method is called each time when a fxml file associated with this object/class is loaded
     */
    public void initialize() {
    	
    	//the method (initialize) is called several times by diferents fxml file loads 
    }
    
    

 /*   
    public UserAccount checkUser(String username, String password) {
    	UserAccount user = null;
    	for(int i=0; i<classroom.size(); i++ ) {
    		if(classroom.get(i).getUserName().equals(username)&&classroom.get(i).getPassword.equals(password))
    			user = classroom.get(i);
    	}
    	return user;
    }
*/    
    @FXML
    void loadLogin(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent addContactPane = fxmlLoader.load();
    	
		mainPanel.getChildren().clear();
    	mainPanel.setTop(addContactPane);

    }


}