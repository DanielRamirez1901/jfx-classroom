package ui;


import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javafx.stage.Stage;
import model.Classroom;
import model.UserAccount;

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
    private TextField ruta;

    
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
    
 
    
       
    /**
     * This method is called each time when a fxml file associated with this object/class is loaded
     */
    public void initialize() {
    	
    	//the method (initialize) is called several times by diferents fxml file loads 
    }
    
    public void initializeTableView() {
    	ObservableList<UserAccount> observableList;
    	observableList = FXCollections.observableArrayList(classroom.getUsers());
    	
		tvUserList.setItems(observableList);
		tcUsername.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("name")); //the tableview search for a method called getName
		tcGender.setCellValueFactory(new PropertyValueFactory<UserAccount,String>("gender")); //the tableview search for a method called getEmail
		tcCareer.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("career"));//the tableview search for a method called getCareer
		tcBirthday.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("birthday"));//the tableview search for a method called getBirthday
		tcBrowser.setCellValueFactory(new PropertyValueFactory<UserAccount, String>("browser"));//the tableview search for a method called getBrowser
		
    }
    
 
    @FXML
    public void loadLogin(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent addContactPane = fxmlLoader.load();
    	
		mainPanel.getChildren().clear();
    	mainPanel.setTop(addContactPane);
    	Stage st = (Stage)
    	addContactPane.getScene().getWindow();
    	st.setHeight(452);
    	st.setWidth(659);

    }
    
    
    @FXML
    public void registerUser(ActionEvent event)throws IOException{
    	Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Informaci�n");
        alert.setHeaderText(null);
    	if(!txtUsername.getText().equals("") && !txtPassword.getText().equals("") ) {
    		classroom.addContact(txtUsername.getText(), txtGender.getText(), txtCareer.getText(),txtBirthday.getText(), txtPassword.getText(),txtBrowser.getText());
    	}//End if
    	txtUsername.setText("");txtPassword.setText("");txtGender.setText("");txtBirthday.setText("");txtCareer.setText("");txtBrowser.setText("");
    	 alert.setContentText("Usuario registrado exitosamente");
    	 loadLogin(event);
    	 alert.showAndWait();

    }
    
    @FXML
    public void loadRegister(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent addContactPane = fxmlLoader.load();
    	
		mainPanel.getChildren().clear();
    	mainPanel.setTop(addContactPane);
    	Stage st = (Stage)
    	addContactPane.getScene().getWindow();
		st.setHeight(575);
		st.setWidth(372);

    }
    
    @FXML
    public void loadAccountList(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("account-list.fxml"));
		
		fxmlLoader.setController(this);    	
		Parent addContactPane = fxmlLoader.load();
    	
		mainPanel.getChildren().clear();
    	mainPanel.setTop(addContactPane);
    	Stage st = (Stage)
    	addContactPane.getScene().getWindow();
    	st.setHeight(481);
    	st.setWidth(526);

    }

 
    
    @FXML
    public void login(ActionEvent event) throws IOException{
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Informaci�n");
        alert.setHeaderText(null);

      
        if(classroom.checkUser(txtUserLogin.getText(), txtUserPassword.getText()) != null) {
            alert.setContentText("Ha iniciado sesi�n correctamente");
            loadAccountList(event);
            
        }else if(classroom.checkUser(txtUserLogin.getText(), txtUserPassword.getText()) == null) {
            alert.setContentText("Usuario y/o contrase�a incorrectos");
            System.out.println(txtUserLogin.getText() +" "+txtUserPassword.getText()+" "+txtUserLogin.getText()+" "+txtUserPassword.getText()+" ");
        }

        alert.showAndWait();


    }
    
    @FXML
    public void showAbout(ActionEvent event) {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Contact Manager");
	    alert.setHeaderText("Credits");
	    alert.setContentText("Daniel Ramirez\nAlgorithms II");


	    alert.showAndWait();
    }
    
    
    


}