package hw.week9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;


public class View extends Application {

    private TextArea pageArea;
    private TextArea emailsArea;
    private TextArea linksArea;
    private TextField charsetField;
    private TextField isHTMLField;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Download the page of a given URL
     *
     * @param url   a string representing a link
     * @return  a string of the page
     */
    private String download(String url) {
        try {
            URLConnection connection = new URL(url).openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder stringBuilder = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                stringBuilder.append(inputLine);
            }
            in.close();

            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Determine whether a given URL is valid or not.
     *
     * @param url   given URL
     * @return  true if valid, false if not
     */
    private boolean isURL(String url) {
        String pattern = "^https?://[\\w]+(\\.[\\w]+)+[/]?$";
        return Pattern.matches(pattern, url.toLowerCase());
    }


    /**
     * Decide whether a page contains HTML tags or not.
     *
     * @param page  a string representing the page
     * @return  true if it contains HTML tages, false if not
     */
    private boolean isHTML(String page) {
        String pattern = ".*<html.*</html>.*";
        return Pattern.matches(pattern, page.toLowerCase());
    }

    /**
     * Return the Charset of the given HTML page.
     *
     * @param page  HTML page string
     * @return  the Charset of this HTML
     */
    private String getCharset(String page) {
        String patternString = "charset\\s*=[\\s\"]*([^\">\\s]*)";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(page);
        while (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /**
     * Return a List object that contains email addresses found in the give HTML page.
     *
     * @param page  HTML page string
     * @return  a List object containing found emails
     */
    private List<String> getEmails(String page) {
        String patternString = "([\\w]+@[\\w]+(\\.[\\w]+)*)";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(page);

        List<String> emails = new ArrayList <>();

        while (matcher.find()) {
            emails.add(matcher.group(1));
        }
        return emails;
    }

    /**
     * Return a List object that contains links addresses found in the give HTML page.
     *
     * @param page  HTML page string
     * @return  a List object containing found links
     */
    private List<String> getLinks(String page) {
        String patternString =
                "\\s*(href|src)\\s*=\\s*(\"([^\"]*\")|(\'[^\']*\')|([^\'\">\\s]+))";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(page);

        List<String> links = new ArrayList <>();

        while (matcher.find()) {
            links.add(matcher.group(2).replace("\"", ""));
        }
        return links;
    }

    /**
     * A helper method that converts a List<String> object to a String object.
     *
     * @param list  a List<String> object
     * @return  a string
     */
    private String listToSting(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s: list) {
            stringBuilder.append(s);
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }


    @Override
    public void start(Stage primaryStage) {

        TextField urlText = new TextField("http://pku.edu.cn");
        Button getBtn = new Button("Get");
        getBtn.setOnAction(e -> {
            String url = urlText.getText();

            if (!isURL(url))
                AlertBox.display("Error", "Entered string is not a valid URL.");
            else {
                String page = download(url);
                charsetField.setText(getCharset(page));
                isHTMLField.setText(isHTML(page)? "Yes": "No");
                linksArea.setText(listToSting(getLinks(page)));
                emailsArea.setText(listToSting(getEmails(page)));
                pageArea.setText(page);
            }
        });

        HBox textBox = new HBox(30);
        textBox.setPadding(new Insets(10, 10, 10, 10));
        textBox.getChildren().addAll(urlText, getBtn);

        HBox controlPane = new HBox(10);
        controlPane.setPadding(new Insets(10, 10, 10, 10));
        controlPane.getChildren().addAll(textBox);


        Label charsetLabel = new Label("Charset: ");
        charsetField = new TextField();
        charsetField.setEditable(false);
        HBox charsetBox = new HBox(10);
        charsetBox.setPadding(new Insets(10, 10, 10, 10));
        charsetBox.getChildren().addAll(charsetLabel, charsetField);


        Label isHTMLLabel = new Label("Is HTML: ");
        isHTMLField = new TextField();
        isHTMLField.setEditable(false);
        HBox isHTMLBox = new HBox(10);
        isHTMLBox.setPadding(new Insets(10, 10, 10, 10));
        isHTMLBox.getChildren().addAll(isHTMLLabel, isHTMLField);



        HBox charsetAndIsHTMLBox = new HBox(50);
        charsetAndIsHTMLBox.getChildren().addAll(charsetBox, isHTMLBox);


        Label linksLabel = new Label("Links: ");
        linksArea = new TextArea();
        linksArea.setEditable(false);
        linksArea.setWrapText(true);
        VBox linksBox = new VBox(10);
        linksBox.setPadding(new Insets(10, 10, 10, 10));
        linksBox.getChildren().addAll(linksLabel, linksArea);


        Label emailsLabel = new Label("Emails: ");
        emailsArea = new TextArea();
        emailsArea.setEditable(false);
        emailsArea.setWrapText(true);
        emailsArea.setPrefHeight(100);
        VBox emailsBox = new VBox(10);
        emailsBox.setPadding(new Insets(10, 10, 10, 10));
        emailsBox.getChildren().addAll(emailsLabel, emailsArea);


        Label pageLabel = new Label("Page Source Code: ");
        pageArea = new TextArea();
        pageArea.setEditable(false);
        pageArea.setWrapText(true);
        VBox pageBox = new VBox(10);
        pageBox.setPadding(new Insets(10, 10, 10, 10));
        pageBox.getChildren().addAll(pageLabel, pageArea);


        VBox returnedDataBox = new VBox();
        returnedDataBox.setPadding(new Insets(10, 10, 10, 10));
        returnedDataBox.getChildren().addAll(charsetAndIsHTMLBox, linksBox, emailsBox, pageBox);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(returnedDataBox, controlPane);

        primaryStage.setScene(new Scene(layout, 800, 600));
        primaryStage.show();
    }
}
