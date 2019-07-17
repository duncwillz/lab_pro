/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DBConnect;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Stream;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Window;
import javafx.util.Duration;
import model.Log;
import model.Subjects;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Kwaku Adjei <duncanadjei@gmail.com>
 */
public class Lab_proController implements Initializable {
    private Subjects subjects;
    private Log log;
    middle md = middle.md();
    ObservableList<Subjects> data;
    ObservableList<Log> datalog;

   @FXML
    private VBox subjectVBOX;

    @FXML
    private TableView<Subjects> subjectTable;

    @FXML
    private TableColumn<Subjects, Integer> colSubjectNumber;

    @FXML
    private TableColumn<Subjects,Date> colSubjectDOB;

    @FXML
    private TableColumn<Subjects, String> colSubjectGroup;
    
    @FXML
    private TableColumn<Subjects, String> colSubjectGender;

    
    @FXML
    private ComboBox<Integer> loggingDateDay;

    @FXML
    private ComboBox<String> loggingDateMonth;

    @FXML
    private ComboBox<Integer> loggingDateYear;

    
    @FXML
    private Button subjectView;

    @FXML
    private Button subjectEnroll;

    @FXML
    private Button subjectArchive;
    
    @FXML
    private Button subjectUpdate;

    @FXML
    private Button subjectClose;

    @FXML
    private VBox logVBOX;

    @FXML
    private TableView<Log> viewLogsTable;

    @FXML
    private TableColumn<Log, Integer> viewLogs;

    @FXML
    private TableColumn<Log, Date> viewDate;

    @FXML
    private TableColumn<Log, Integer> viewRequisition;

        @FXML
    private TableColumn<Log, Integer> viewTrackingNumber;

    @FXML
    private TableColumn<Log, Date> viewTime;

    @FXML
    private TableColumn<Log, Integer> viewParasite;

    @FXML
    private VBox viewUpdateLog;

    @FXML
    private Button viewAddLog;

    @FXML
    private Button viewDeleteLog;

    @FXML
    private Label viewSubjectNumber;

    @FXML
    private VBox addLogVBOX;

    @FXML
    private TextField loggingNumber;

    @FXML
    private TextField loggingRequsitionNumber;


    
    @FXML
    private CheckBox loggingParasiteStatus;

    @FXML
    private TextField loggingTrackingNumber;
    
    @FXML
    private TextField loggingTimeHour;

    @FXML
    private TextField loggingTimeMinute;
    @FXML
    private Button loggingSave;

    @FXML
    private Label viewSubjectNumber1;

    @FXML
    private VBox enrollSujectVBOX;

    @FXML
    private TextField enrollSubjectNumber;

    @FXML
    private DatePicker enrollSubjectDOB;

    @FXML
    private Button enrollSave;

    @FXML
    private ComboBox<String> enrollComboGroup;

    @FXML
    private ComboBox<String> enrollComboGender;
    @FXML
    private TextField searchSubject;
    @FXML
    private Button viewClose;
    @FXML
    private Button loggingClose;
    @FXML
    private TextField parasitologyNumber;
    @FXML
    private Button enrollClose;
    @FXML
    private TableColumn<?, ?> scheduleVisitCol;
    @FXML
    private TableColumn<?, ?> scheduleDateCol;
    @FXML
    private TableColumn<?, ?> scheduleTimeCol;
    @FXML
    private TableColumn<?, ?> scheduleParasitemiaCol;
    @FXML
    private TableColumn<?, ?> scheduleGenotypingCol;
    @FXML
    private VBox viewUpdateLog1;
    @FXML
    private Button addNewSchedule;
    @FXML
    private Button viewDeleteLog1;
    @FXML
    private TextField schduleVisitNumber;
    @FXML
    private TextField scheduleParasitemia;
    @FXML
    private TextField scheduleGenotyping;
    @FXML
    private TextField scheduleHour;
    @FXML
    private TextField scheduleMinute;
    @FXML
    private Button loggingClose1;
    @FXML
    private ComboBox<?> scheduleDay;
    @FXML
    private ComboBox<?> scheduleMonth;
    @FXML
    private ComboBox<?> scheduleYear;
    @FXML
    private TextField scheduleImmunogenecity;
    @FXML
    private TextField scheduleHeamoglobin;
    @FXML
    private TextField schedulePlatelets;
    @FXML
    private TextField scheduleWBC;
    @FXML
    private TextField scheduleCreatinine;
    @FXML
    private TextField scheduleALT;
    @FXML
    private Button subjectView1;
    @FXML
    private VBox trackVBOX;
    @FXML
    private ComboBox<?> trackUnscheduledCombo;
    @FXML
    private TextField searchTextTrackUnschedule;
    @FXML
    private TableView<?> trackUnscheduleVisitTable;
    @FXML
    private TableColumn<?, ?> ColTrackUnscheduleSubjectNo;
    @FXML
    private TableColumn<?, ?> ColTrackUnscheduleDate;
    @FXML
    private TableColumn<?, ?> ColTackUnscheduleTime;
    @FXML
    private TableColumn<?, ?> ColTrackUnscheduleFTA;
    @FXML
    private TableColumn<?, ?> ColTrackUnscheduleRequisition;
    @FXML
    private TableColumn<?, ?> ColTrackUnscheduleParasitology;
    @FXML
    private ComboBox<?> trackScheduledCombo;
    @FXML
    private TextField trackScheduleSearchTextBox;
    @FXML
    private TableView<?> trackScheduleVisitTable;
    @FXML
    private TableColumn<?, ?> ColtrackScheduleSubjectNo;
    @FXML
    private TableColumn<?, ?> ColTrackScheduleVisit;
    @FXML
    private TableColumn<?, ?> colTrackScheduleDate;
    @FXML
    private TableColumn<?, ?> colTrackScheduleTime;
    @FXML
    private TableColumn<?, ?> colTrackScheduleParasitemia;
    @FXML
    private TableColumn<?, ?> colTrackScheduleGenotyping;
    @FXML
    private TableColumn<?, ?> colTrackScheduleImmuno;
    @FXML
    private TableView<?> scheduleTableView;
    @FXML
    private TableColumn<?, ?> scheduleImmunogenCol;

    @FXML
    void addLog(ActionEvent event) {
    regulateView(false, false, true, false);
        loggingSave.setText("SAVE");
        Translate(addLogVBOX);
        loggingNumber.setText(Integer.toString(DBConnect.getInstance().logsCountForSubject(final_subject_number)+1));
    }
    
  
    @FXML
    void updateLog(ActionEvent event){
   if(viewLogsTable.getSelectionModel().getSelectedIndex()<0){
          note("Error", "Please select a subject to proceed with this action");
        }
        else{
                loggingSave.setText("UPDATE");
               regulateView(false, false, true, false);
               loggingNumber.setEditable(true);
              Translate(addLogVBOX);
              int subject_id, log_id;
              subject_id =viewLogsTable.getSelectionModel().getSelectedItem().getSubjectid();
              log_id = viewLogsTable.getSelectionModel().getSelectedItem().getId();
              List<Log> selected = DBConnect.getInstance().findAllLogOfSubject(subject_id,log_id);
          //    List<Log> selected  = DBConnect.getInstance().findAllLog(viewLogsTable.getSelectionModel().getSelectedItem().getSubjectid());
              
              loggingNumber.setText(selected.get(0).getLognumber()+"");
              loggingRequsitionNumber.setText(selected.get(0).getRequsitionnumber()+"");
              if(selected.get(0).getParasite().equals("Positive")){
                 loggingParasiteStatus.selectedProperty().setValue(true);
              }else{
              loggingParasiteStatus.selectedProperty().setValue(false);
              }
              loggingTrackingNumber.setText(selected.get(0).getTrackingnumber()+"");
              SimpleDateFormat sdf = new SimpleDateFormat("HH");
              loggingTimeHour.setText(sdf.format(selected.get(0).getCollectiontime()));
              sdf = new SimpleDateFormat("mm");
              loggingTimeMinute.setText(sdf.format(selected.get(0).getCollectiontime()));
              sdf = new SimpleDateFormat("d");
              loggingDateDay.setValue(Integer.parseInt(sdf.format(selected.get(0).getCollectiondate())));
               sdf = new SimpleDateFormat("MMM");
              loggingDateMonth.setValue(sdf.format(selected.get(0).getCollectiondate()));
                sdf = new SimpleDateFormat("yyyy");
              loggingDateYear.setValue(Integer.parseInt(sdf.format(selected.get(0).getCollectiondate())));
              final_log_id=selected.get(0).getId();
              parasitologyNumber.setText(selected.get(0).getParasitology()+"");
          }
    }

    @FXML
    void closeSubject(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void deleteLog(ActionEvent event) {
          if(viewLogsTable.getSelectionModel().getSelectedIndex()<0){
          note("Error", "Please select a subject to proceed with this action");
        }
        else{
              if (AlertSelected("Warning","Are you sure you want to delete?","The selected item for deletion cannot be undo, do you want to continue?", "Accept")){
                  if(DBConnect.getInstance().delete(viewLogsTable.getSelectionModel().getSelectedItem())){
                 populateSubjectLogsTable(final_subject_number);
                 note("Delete", "Log deleted successfully");
                    }  
              }
          }
    }
    
    @FXML
    void archiveSubject(ActionEvent event){
    
    }

    @FXML
    void enrollSubject(ActionEvent event) {
        enrollSave.setText("SAVE");
        regulateView(false, false, false, true);
        Translate(enrollSujectVBOX);
    }
    
    int final_id = 0;
    int final_subject_number = 0;
    int final_log_id = 0;
    @FXML
    void saveEnrollSubject(ActionEvent event) {
        if(enrollSave.getText().equals("SAVE")&&isValidatedEnroll()){
        subjects.setSubjectid(Integer.parseInt(enrollSubjectNumber.getText().trim()));
        Date date = Date.valueOf(enrollSubjectDOB.getValue());
        subjects.setDob(date);
        subjects.setGender(enrollComboGender.getSelectionModel().getSelectedItem());
        subjects.setGroup(enrollComboGroup.getSelectionModel().getSelectedItem());
        if(DBConnect.getInstance().create(subjects)){
                note("Saved","Data saved successfully");
                populateSubjectsTable();
                refreshEnrollFields();
            }
        }
        else if (enrollSave.getText().equals("UPDATE")&&isValidatedEnroll()){
        subjects.setSubjectid(Integer.parseInt(enrollSubjectNumber.getText().trim()));
        Date date = Date.valueOf(enrollSubjectDOB.getValue());
        subjects.setDob(date);
        subjects.setGender(enrollComboGender.getSelectionModel().getSelectedItem());
        subjects.setGroup(enrollComboGroup.getSelectionModel().getSelectedItem());
        subjects.setId(final_id);
        log.setSubjectid(subjects.getSubjectid());
        if(DBConnect.getInstance().update(subjects)){
                note("Update","Data updated successfully");
                populateSubjectsTable();
                refreshEnrollFields();
                regulateView(true,false,false, false);
                Translate(subjectVBOX);
            }}
    }

    @FXML
    void saveLogging(ActionEvent event) {
        
         if(loggingSave.getText().equals("SAVE")&&isValidatedLog()){
             log.setLognumber(Integer.parseInt(loggingNumber.getText().trim()));
             log.setSubjectid(Integer.parseInt(viewSubjectNumber1.getText().trim()));
             log.setRequsitionnumber(Integer.parseInt(loggingRequsitionNumber.getText().trim()));
             log.setCollectiondate(getLogDate());
             log.setCollectiontime(getTimeEncoded());
             System.out.println(getTimeEncoded());
             log.setParasite(getParasiteStatus());
             log.setTrackingnumber(Integer.parseInt(loggingTrackingNumber.getText().trim()));
             log.setParasitology(Integer.parseInt(parasitologyNumber.getText().trim()));
        if(DBConnect.getInstance().create(log)){
                note("Logged","Successfully");
                refreshEnrollFields();
                refreshDateDay();
                populateSubjectLogsTable(Integer.parseInt(viewSubjectNumber1.getText().trim()));
            }
        }
         else if(loggingSave.getText().equals("UPDATE")){
             log.setLognumber(Integer.parseInt(loggingNumber.getText().trim()));
             log.setSubjectid(Integer.parseInt(viewSubjectNumber1.getText().trim()));
             log.setRequsitionnumber(Integer.parseInt(loggingRequsitionNumber.getText().trim()));
             log.setCollectiondate(getLogDate());   
             log.setCollectiontime(getTimeEncoded());
             log.setParasite(getParasiteStatus());
             log.setTrackingnumber(Integer.parseInt(loggingTrackingNumber.getText().trim()));
             log.setParasitology(Integer.parseInt(parasitologyNumber.getText().trim()));
             log.setId(final_log_id);
              if(DBConnect.getInstance().update(log)){
                note("Updated","Successfully");
                refreshEnrollFields();
                refreshDateDay();
                populateSubjectLogsTable(Integer.parseInt(viewSubjectNumber1.getText().trim()));
                loggingNumber.setEditable(false);  
                regulateView(false, true,false, false);
                Translate(logVBOX);
            }
         }
    }
    
    private Time getTimeEncoded(){
        DateFormat sdf = new SimpleDateFormat("hh:mm");
        if (loggingTimeHour.getText().isEmpty()||loggingTimeMinute.getText().isEmpty()){
            note("Error", "Please indicate time of collection");
            return null;
        }else{
            String timeCollection = loggingTimeHour.getText()+":"+loggingTimeMinute.getText();
                try{
                    LocalTime localTime = LocalTime.parse(timeCollection);
                return java.sql.Time.valueOf(localTime);
        }catch(Exception e){e.printStackTrace();}
        }
        return null;
        }

    private String getParasiteStatus(){
        if (loggingParasiteStatus.isSelected()){
            return "Positive";
        }else {
            return "Negative";
        }
    }
    
    @FXML
    void updateSubject(ActionEvent event) {
         if(subjectTable.getSelectionModel().getSelectedIndex()<0){
          note("Error", "Please select a subject to proceed with this action");
        }
        else{
        List<Subjects> subjects = DBConnect.getInstance().getSubjectByID(subjectTable.getSelectionModel().getSelectedItem().getSubjectid());
        enrollSubjectNumber.setText(subjects.get(0).getSubjectid()+"");
        enrollSubjectDOB.setValue(subjects.get(0).getDob().toLocalDate());
        enrollComboGender.setValue(subjects.get(0).getGender());
        enrollComboGroup.setValue(subjects.get(0).getGroup());
        final_id=subjects.get(0).getId();
        regulateView(false, false, false, true);
        Translate(enrollSujectVBOX);
        enrollSave.setText("UPDATE");
        }
        
        
    }
    @FXML
    void close(ActionEvent event) {
        regulateView(true,false,false, false);
        Translate(subjectVBOX);
        refreshEnrollFields();
    }
    
    @FXML 
     void closeAddLog(ActionEvent event) {
        regulateView(false,true,false,false);
        Translate(logVBOX);
        refreshEnrollFields();
    }
    @FXML
    void viewSubject(ActionEvent event) {
        if(subjectTable.getSelectionModel().getSelectedIndex()<0){
          note("Error", "Please select a subject to proceed with this action");
        }
        else{
            if (md.isFriday()){
                md.backUpData();
           }
            final_subject_number = subjectTable.getSelectionModel().getSelectedItem().getSubjectid();
        populateSubjectLogsTable(final_subject_number);
        regulateView(false, true,false, false);
        Translate(logVBOX);
        viewSubjectNumber.setText("SUBJECT NUMBER: "+ final_subject_number); 
        viewSubjectNumber1.setText(final_subject_number+""); 
        }
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         this.data = FXCollections.observableArrayList();
        this.subjects = new Subjects();
        this.log = new Log();
        md = middle.md();
         populateSubjectsTable();
         populateCombo();
         AutoSearch();
         refreshDateDay();
        // TODO
    }   
    
    public void regulateView(boolean v1,boolean v2,boolean v3,boolean v4){
    subjectVBOX.setVisible(v1);
    logVBOX.setVisible(v2);
    addLogVBOX.setVisible(v3);
    enrollSujectVBOX.setVisible(v4);
    searchSubject.setVisible(v1);
   }
    
    public void populateSubjectsTable(){
            subjectTable.getItems().clear();
            colSubjectNumber.setCellValueFactory(new PropertyValueFactory<Subjects, Integer>("subjectid"));
            colSubjectDOB.setCellValueFactory(new PropertyValueFactory<Subjects, Date>("dob"));
             colSubjectDOB.setCellFactory(column -> {
            TableCell<Subjects, Date> cell = new TableCell<Subjects, Date>() {
                private SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    if(empty) {
                        setText(null);
                    }
                    else {
                        setText(format.format(item));
                    }
                }
            };
            return cell;
        });
            colSubjectGroup.setCellValueFactory(new PropertyValueFactory<Subjects, String>("group"));
             colSubjectGender.setCellValueFactory(new PropertyValueFactory<Subjects, String>("gender"));
            data = FXCollections.observableArrayList();
            data.addAll(DBConnect.getInstance().findAllSubjects());
            subjectTable.setItems(data);
    }
    
    
    public void populateSubjectLogsTable(int selectSubjectid){
            viewLogsTable.getItems().clear();
            viewLogs.setCellValueFactory(new PropertyValueFactory<Log, Integer>("lognumber"));
            viewRequisition.setCellValueFactory(new PropertyValueFactory<Log, Integer>("requsitionnumber"));
            viewDate.setCellValueFactory(new PropertyValueFactory<Log, Date>("collectiondate"));
            viewDate.setCellFactory(column -> {
            TableCell<Log, Date> cell = new TableCell<Log, Date>() {
                private SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);
                    if(empty) {
                        setText(null);
                    }
                    else {
                        setText(format.format(item));
                    }
                }
            };
            return cell;
        });
       viewTime.setCellValueFactory(new PropertyValueFactory<Log, Date>("collectiontime"));
            viewTrackingNumber.setCellValueFactory(new PropertyValueFactory<Log, Integer>("trackingnumber"));
            viewParasite.setCellValueFactory(new PropertyValueFactory<Log, Integer>("parasitology"));
            datalog = FXCollections.observableArrayList();
            datalog.addAll(DBConnect.getInstance().findAllLog(selectSubjectid));
            viewLogsTable.setItems(datalog);
    }
    
    public void refreshEnrollFields(){
    populateCombo();
    enrollSubjectNumber.setText("");
    enrollSubjectDOB.setValue(null);
    loggingNumber.setText("");
    loggingRequsitionNumber.setText("");
    loggingTimeHour.setText("");
    loggingTimeMinute.setText("");
    loggingTrackingNumber.setText("");
    loggingParasiteStatus.selectedProperty().setValue(false);
    }
    
    public void refreshDateDay(){
        loggingDateDay.getItems().clear();
        loggingDateMonth.getItems().clear();
        loggingDateYear.getItems().clear();
//        loggingDateDay.setSelectionModel(null);
//        loggingDateYear.setSelectionModel(null);
//        loggingDateMonth.setSelectionModel(null);
        List<Integer>daysInMonth = new ArrayList<>();
        for (int i=0; i<32;i++){
            daysInMonth.add(i);
        }
        daysInMonth.remove(0);
        loggingDateDay.getItems().addAll(daysInMonth);
        loggingDateMonth.getItems().addAll("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
        loggingDateYear.getItems().addAll(2017,2018,2019,2020);
        new ComboBoxAutoComplete<Integer>(loggingDateDay);
        new ComboBoxAutoComplete<String>(loggingDateMonth);
        new ComboBoxAutoComplete<Integer>(loggingDateYear);
    }
    
    public java.sql.Date getLogDate() {
        java.sql.Date tosend =null;
        if (loggingDateDay.getValue()==null||loggingDateMonth.getValue()==null|| loggingDateYear.getValue()==null){
            note("Error", "Please enter Date");
            return null;
        }else{
            try{
                String dateSelected ;
                if (loggingDateDay.getValue()>9){
                 dateSelected = loggingDateDay.getValue()+"-"+loggingDateMonth.getValue()+"-"+loggingDateYear.getValue();
                }else{
                   dateSelected ="0"+ loggingDateDay.getValue()+"-"+loggingDateMonth.getValue()+"-"+loggingDateYear.getValue();
                }
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                String dateInString = dateSelected;
                  java.util.Date date = formatter.parse(dateInString);
                  System.out.println(date);
                    java.sql.Date sd = new java.sql.Date(date.getTime()); 
                return sd;
            }catch(ParseException e){
            e.printStackTrace();
            }
       }
        return null;
    }
    
    public void populateCombo(){
        enrollComboGender.getItems().clear();
        enrollComboGender.getItems().addAll("Male", "Female");
        enrollComboGroup.getItems().clear();
        enrollComboGroup.getItems().addAll("R012-20","RO12-14MD","Fx012-14-mFxD","Fx017-mFxD","Control group");
    }
     public boolean isValidatedEnroll(){
           if(enrollSubjectNumber.getText().isEmpty() ||enrollComboGender.getSelectionModel().getSelectedIndex()<0
                   ||enrollComboGroup.getSelectionModel().getSelectedIndex()<0||enrollSubjectDOB.getValue()==null){
               note("Enroll","Please all fields are required");
               return false;
           }
           
           return true;
       }
     
     public boolean isValidatedLog(){
     if(loggingNumber.getText().isEmpty() ||loggingRequsitionNumber.getText().isEmpty()){
               note("Enroll","Please all fields are required");
               return false;
           }
           
           return true;
     
     }
            
       public void note(String title, String text) {
        Notifications showNotice = Notifications.create()
                .title(title)
                .text(text)
                .hideAfter(Duration.seconds(4))
                .position(Pos.BASELINE_RIGHT);
        showNotice.darkStyle();
        Platform.runLater(() -> {
            showNotice.show();
        });
    }
       
   public boolean AlertSelected(String... details) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(details[0]);
        alert.setHeaderText(details[1]);
        alert.setContentText(details[2]);
        ButtonType typeone = new ButtonType(details[3]);
        ButtonType typetwo = new ButtonType("Cancel");
        alert.getButtonTypes().setAll(typeone, typetwo);
        Optional<ButtonType> results = alert.showAndWait();
        if (results.get() == typeone) {
            return true;
        } else if (results.get() == typetwo) {
            return false;
        }
        return false;
    }    
       
          public void Translate(Node pane) {
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.millis(200));
        tt.setNode(pane);
        tt.setByY(50);
        tt.setCycleCount(2);
        tt.setAutoReverse(true);
        tt.play();
    }
        public void restrictInputs(TextField fields){
        fields.textProperty().addListener((observable, oldValue, newValue) -> {
               if (!newValue.matches("\\d*")) {
                          fields.setText(newValue.replaceAll("[^\\d]", ""));
                }
          });
        }
        
        public void restrictAllInputs(){
            restrictInputs(loggingNumber);
            restrictInputs(loggingRequsitionNumber);
            restrictInputs(loggingTrackingNumber);
            restrictInputs(enrollSubjectNumber);
            restrictInputs(loggingTimeHour);
            restrictInputs(loggingTimeMinute);
        }
        
        
      public void AutoSearch() {
         restrictAllInputs();
        FilteredList<Subjects> filteredData = new FilteredList<>(data, e -> true);
        searchSubject.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
            filteredData.setPredicate((Predicate<? super Subjects>) subjects -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                if (Integer.toString(subjects.getSubjectid()).toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                }
                return false;
            });
        });
        SortedList<Subjects> sortdata = new SortedList<>(filteredData);
        sortdata.comparatorProperty().bind(subjectTable.comparatorProperty());
        subjectTable.setItems(sortdata);
    }

    @FXML
    private void addSchedule(ActionEvent event) {
    }

    @FXML
    private void updateSchedule(ActionEvent event) {
    }

    @FXML
    private void deleteSchedule(ActionEvent event) {
    }

    @FXML
    private void scheduleVisitSave(ActionEvent event) {
    }

      
    public class ComboBoxAutoComplete<T> {

        private ComboBox<T> cmb;
        String filter = "";
        private ObservableList<T> originalItems;

        public ComboBoxAutoComplete(ComboBox<T> cmb) {
            this.cmb = cmb;
            originalItems = FXCollections.observableArrayList(cmb.getItems());
            cmb.setTooltip(new Tooltip());
            cmb.setOnKeyPressed(this::handleOnKeyPressed);
            cmb.setOnHidden(this::handleOnHiding);
        }

        public void handleOnKeyPressed(KeyEvent e) {
            ObservableList<T> filteredList = FXCollections.observableArrayList();
            KeyCode code = e.getCode();

            if (code.isLetterKey()) {
                filter += e.getText();
            }
            if(code.isDigitKey()){
                filter += e.getText();
            }
            if(code.isKeypadKey()){
                filter += e.getText();
            }
            if (code == KeyCode.BACK_SPACE && filter.length() > 0) {
                filter = filter.substring(0, filter.length() - 1);
                cmb.getItems().setAll(originalItems);
            }
            if (code == KeyCode.ESCAPE) {
                filter = "";
            }
            if (filter.length() == 0) {
                filteredList = originalItems;
                cmb.getTooltip().hide();
            } else {
                Stream<T> itens = cmb.getItems().stream();
                String txtUsr = filter.toString().toLowerCase();
                itens.filter(el -> el.toString().toLowerCase().contains(txtUsr)).forEach(filteredList::add);
                cmb.getTooltip().setText(txtUsr);
                Window stage = cmb.getScene().getWindow();
                double posX = stage.getX() + cmb.getBoundsInParent().getMinX();
                double posY = stage.getY() + cmb.getBoundsInParent().getMinY();
                cmb.getTooltip().show(stage, posX, posY);
                cmb.show();
            }
            cmb.getItems().setAll(filteredList);
        }

        public void handleOnHiding(Event e) {
            filter = "";
            cmb.getTooltip().hide();
            T s = cmb.getSelectionModel().getSelectedItem();
            cmb.getItems().setAll(originalItems);
            cmb.getSelectionModel().select(s);
        }
    }
      
 }
