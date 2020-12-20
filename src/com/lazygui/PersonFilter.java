package com.lazygui;

import com.miller.Condition;
import com.miller.Gender;
import com.miller.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import jfxtras.styles.jmetro.JMetro;

import java.io.File;
import java.sql.SQLException;

public class PersonFilter extends Application {
  MenuItem refreshMenu;
  MenuItem printMenu;
  MenuItem deleteMenu;
  MenuItem updateMenu;
  Menu filterMenu;

  TableView<Person> personTableView;

  public void printPerson(Person person, Event event) {

    Label nameLabel = new Label("Name");
    TextField nameTextField = new TextField();
    nameTextField.setText(person.get_name());

    Label surnameLabel = new Label("Surname");
    TextField surnameTextField = new TextField();
    surnameTextField.setText(person.get_surname());

    Label genderLabel = new Label("Gender");
    TextField genderTextField = new TextField();
    genderTextField.setText(person.get_gender().toString());

    Label ageLabel = new Label("Age");
    TextField ageTextField = new TextField();
    ageTextField.setText(String.valueOf(person.get_age()));

    Button update = new Button("Update");

    if (event.getSource().equals(printMenu)) {
      nameTextField.setEditable(false);
      surnameTextField.setEditable(false);
      ageTextField.setEditable(false);
      genderTextField.setEditable(false);
    }

    GridPane printGridPane = new GridPane();
    printGridPane.setVgap(10);
    printGridPane.setHgap(10);
    printGridPane.setPadding(new Insets(5));

    printGridPane.addRow(1, nameLabel, nameTextField);
    printGridPane.addRow(2, surnameLabel, surnameTextField);
    printGridPane.addRow(3, genderLabel, genderTextField);
    printGridPane.addRow(4, ageLabel, ageTextField);

    if (event.getSource().equals(updateMenu)) {
      printGridPane.add(update, 1, 5);
    }

    printGridPane.autosize();
    Scene scene = new Scene(printGridPane);
    new JMetro().setScene(scene);
    Stage printStage = new Stage();
    printStage.setScene(scene);
    printStage.show();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    // left side of the GUI
    Label name = new Label("Name");
    name.setFont(Font.font("sans-serif"));

    TextField nameField = new TextField();
    nameField.setStyle("-fx-font-family: sans-serif;-fx-font-size: 14px");

    Label surname = new Label("Surname");
    surname.setFont(Font.font("sans-serif"));

    TextField surnameField = new TextField();
    surnameField.setFont(Font.font("sans-serif"));
    surnameField.setStyle("-fx-font-family: sans-serif;-fx-font-size: 14px");

    Label age = new Label("Age");
    age.setFont(Font.font("sans-serif"));

    TextField ageField = new TextField();
    ageField.setStyle("-fx-font-family: sans-serif;-fx-font-size: 14px");

    Label gender = new Label("Gender");
    gender.setFont(Font.font("sans-serif"));

    ComboBox<String> genderComboBox = new ComboBox<String>();
    genderComboBox.getItems().addAll(Gender.MALE.toString(), Gender.FEMALE.toString());

    Button saveButton = new Button("Save");
    saveButton.setFont(Font.font("sans-serif"));
    saveButton.setPrefWidth(150);

    // event handling for save button
    saveButton.setOnAction(
        e -> {
          try {
            Person.savePerson(
                new Person(
                    nameField.getText(),
                    surnameField.getText(),
                    Gender.valueOf(genderComboBox.getSelectionModel().getSelectedItem().toString()),
                    Integer.parseInt(ageField.getText())));
          } catch (SQLException exception) {
            exception.printStackTrace();
          }
        });

    // right side of the GUI

    TextField searchTextField = new TextField();
    searchTextField.setPrefWidth(500);

    Button searchBtn = new Button();
    ImageView searchImage =
        new ImageView("file:src\\com\\lazygui\\icons8_google_web_search_16.png");
    searchBtn.setGraphic(searchImage);

    HBox searchBar = new HBox();
    searchBar.setSpacing(5);
    searchBar.getChildren().addAll(searchTextField, searchBtn);

    personTableView = new TableView<>();

    personTableView.setPrefWidth(500);
    TableColumn<Person, String> colName = new TableColumn<>("Name");
    colName.setCellValueFactory(new PropertyValueFactory<Person, String>("_name"));
    colName.setPrefWidth(125);

    TableColumn<Person, String> colSurname = new TableColumn<>("Surname");
    colSurname.setCellValueFactory(new PropertyValueFactory<Person, String>("_surname"));
    colSurname.setPrefWidth(125);

    TableColumn<Person, Integer> colAge = new TableColumn<>("Age");
    colAge.setPrefWidth(125);
    colAge.setCellValueFactory(new PropertyValueFactory<Person, Integer>("_age"));

    ObservableList<Gender> genders = FXCollections.observableArrayList(Gender.values());

    TableColumn colGender = new TableColumn<>("Gender");
    personTableView.setEditable(true);
    colGender.setCellFactory(ComboBoxTableCell.forTableColumn(genders));
    colGender.setCellValueFactory(new PropertyValueFactory<Person, String>("_gender"));
    colGender.setPrefWidth(125);

    personTableView.getColumns().addAll(colName, colSurname, colAge, colGender);
    personTableView.setItems(FXCollections.observableArrayList(Person.getPersons()));

    personTableView.getItems().addListener(new ListChangeListener<Person>() {
      @Override
      public void onChanged(Change<? extends Person> c) {

      }
    });

    // Context Menu
    MenuBar menuBar = new MenuBar();
    refreshMenu = new MenuItem("Refresh");
    printMenu = new MenuItem("Show");
    deleteMenu = new MenuItem("Delete");
    updateMenu = new MenuItem("Update");
    filterMenu = new Menu("Filter By");

    MenuItem ageFilItem = new MenuItem("Age");
    MenuItem genderFilItem = new MenuItem("Gender");

    filterMenu.getItems().addAll(genderFilItem, ageFilItem);

    // Context Menu event handling
    refreshMenu.setOnAction(
        event -> {
          personTableView.refresh();
        });

    printMenu.setOnAction(
        event -> {
          printPerson(personTableView.getSelectionModel().getSelectedItem(), event);
        });

    updateMenu.setOnAction(
        event -> {
          printPerson(personTableView.getSelectionModel().getSelectedItem(), event);
        });

    ageFilItem.setOnAction(event -> {
      Label filter = new Label();
      filter.setText("Age:");

      TextField filterTextField = new TextField();
      HBox filterHBox = new HBox();
      filterHBox.getChildren().addAll(filter, filterTextField);

      try {
        personTableView.setItems(FXCollections.observableArrayList(Person.getPersonsByCondition(person -> person.get_age() == Integer.parseInt(filterTextField.getText()))));
      } catch (SQLException exception) {
        exception.printStackTrace();
      }

      Scene scene = new Scene(filterHBox);
      Stage filterStage = new Stage();
      filterStage.setScene(scene);
      filterStage.show();

    });

    genderFilItem.setOnAction(event -> {
      Label filter = new Label();
      filter.setText("Gender:");

      TextField filterTextField = new TextField();
      HBox filterHBox = new HBox();
      filterHBox.getChildren().addAll(filter, filterTextField);

      try {
        personTableView.setItems(FXCollections.observableArrayList(Person.getPersonsByCondition(person -> person.get_gender() == Gender.valueOf(filterTextField.getText()))));
      } catch (SQLException exception) {
        exception.printStackTrace();
      }

      Scene scene = new Scene(filterHBox);
      Stage filterStage = new Stage();
      filterStage.setScene(scene);
      filterStage.show();
    });


    ContextMenu contextMenu = new ContextMenu();
    contextMenu.getItems().addAll(refreshMenu, deleteMenu, updateMenu, filterMenu, printMenu);

    personTableView.setOnMouseClicked(
        event -> {
          if (event.getButton().compareTo(MouseButton.SECONDARY) == 0) {
            contextMenu.show(primaryStage, event.getScreenX(), event.getScreenY());
          }
        });

    VBox rightVBox = new VBox();
    rightVBox.setPadding(new Insets(0, 10, 0, 0));
    // rightVBox.setStyle("-fx-border-width: 1px;-fx-border-color: darkblue");
    rightVBox.setPrefWidth(500);
    rightVBox.setSpacing(5);
    rightVBox.getChildren().addAll(searchBar, personTableView);
    rightVBox.setPadding(new Insets(13));
    GridPane gridPane = new GridPane();

    gridPane.setVgap(15);
    gridPane.setHgap(5);

    gridPane.add(name, 1, 1);
    gridPane.add(nameField, 2, 1);
    gridPane.add(surname, 1, 2);
    gridPane.add(surnameField, 2, 2);
    gridPane.add(age, 1, 3);
    gridPane.add(ageField, 2, 3);
    gridPane.add(gender, 1, 4);
    gridPane.add(genderComboBox, 2, 4);
    gridPane.add(saveButton, 2, 5);
    Separator separator = new Separator();
    separator.setStyle("-fx-background-color: blueviolet");
    separator.setOrientation(Orientation.VERTICAL);

    gridPane.addColumn(3, separator);
    gridPane.setRowSpan(separator, 55);
    //    gridPane.addColumn(5,rightVBox);
    //    gridPane.setColumnSpan(rightVBox,3);
    //    gridPane.setColumnSpan(saveButton, 2);

    HBox gloHBox = new HBox();
    gloHBox.getChildren().addAll(gridPane, rightVBox);
    gloHBox.setPadding(new Insets(5));
    gloHBox.autosize();
    Scene scene = new Scene(gloHBox, 800, 500);
    new JMetro().setScene(personTableView.getScene());
    primaryStage.setScene(scene);

    primaryStage.show();
  }
}
