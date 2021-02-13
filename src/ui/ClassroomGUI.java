package ui;


import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	private TextField txtUserLogin;

	@FXML
	private PasswordField txtUserPassword;
	
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
    	
    	classroom = new Classroom();    	
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
    

    @FXML
    void loadLogin(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent addContactPane = fxmlLoader.load();
    	
		mainPanel.getChildren().clear();
    	mainPanel.setTop(addContactPane);

    }
    
    @FXML
    void login(ActionEvent event) throws IOException{
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);

        String user = "a";
        String password = "a";

        if(txtUserLogin.getText().equals(user) && txtUserPassword.getText().equals(password)) {
            alert.setContentText("Ha iniciado sesión correctamente");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
    		
    		fxmlLoader.setController(this);    	
    		Parent addContactPane = fxmlLoader.load();
        	
    		mainPanel.getChildren().clear();
        	mainPanel.setTop(addContactPane);
            
        }else {
            alert.setContentText("U y/o contraseña incorrectos");
            System.out.println(user +" "+password+" "+txtUserLogin.getText()+" "+txtUserPassword.getText()+" ");
        }

        alert.showAndWait();


    }


}