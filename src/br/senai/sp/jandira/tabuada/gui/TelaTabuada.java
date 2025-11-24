package br.senai.sp.jandira.tabuada.gui;

import br.senai.sp.jandira.tabuada.model.TabuadaUsuario;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class TelaTabuada extends Application {


    @Override
    public void start(Stage stage) throws Exception {
            // definir o tamanho da tela //
      //stage.setWidth(600);
        stage.setHeight(700);
        stage.setTitle("Tabuada");
        stage.setResizable(false);


        // Criar o root - componente de leiaute principal //
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #ffffff;");


       // Criamos a cena e colocamos o root nela
        Scene scene = new Scene(root);



        //Criar o header da tela
        VBox header = new VBox();
        //header.setPrefHeight(100);//
        header.setStyle("-fx-background-color: #ff58de;");

        //Colocar o conteudo do header//
        Label labeltitulo = new Label("Tabuada");
        labeltitulo.setPadding(new Insets(8, 8, 0, 8));
        labeltitulo.setStyle("-fx-text-fill: white;-fx-font-size: 20px;-fx-font-weight: bold;");

        Label labelsubtitulo = new Label("Crie a tabuada que a sua imaginação mandar");
        labelsubtitulo.setPadding(new Insets(0, 8, 8, 8));
        labelsubtitulo.setStyle("-fx-text-fill: #ffffff;");

        // Colocar os Labels dentro do header
            header.getChildren().addAll(labeltitulo, labelsubtitulo);


        //Criar o grid do formulário//
        GridPane gridFormulario = new GridPane();
        //gridFormulario.setPrefHeight(100);//
        gridFormulario.setStyle("-fx-background-color: #ff58de;");
        gridFormulario.setVgap(10);
        gridFormulario.setHgap(10);
        gridFormulario.setPadding(new Insets(16, 8, 16, 8));

        //Conteudo do grid do formulário
        Label labelmultiplicando = new Label("multiplicando");
        TextField textFieldmultiplicando = new TextField();

        Label labelMenormultiplicador = new Label("Menor Multiplicador");
        TextField textFieldMenormultiplicador = new TextField();

        Label labelMaiormultiplicador = new Label("Maior Multiplicador");
        TextField textFieldMaiormultiplicador = new TextField();




        //Colocar os componentes no grid
        gridFormulario.add(labelmultiplicando, 0, 0);
        gridFormulario.add(textFieldmultiplicando, 1, 0);

        gridFormulario.add(labelMenormultiplicador, 0, 1);
        gridFormulario.add(textFieldMenormultiplicador, 1, 1);

        gridFormulario.add(labelMaiormultiplicador, 0, 2);
        gridFormulario.add(textFieldMaiormultiplicador, 1, 2);



        //Criar a caixa dos botões
        Pane paneButtons = new Pane();
        paneButtons.setPadding(new Insets(16, 0, 8, 0));

        HBox boxBotoes = new HBox();
        boxBotoes.setPadding(new Insets(16, 0, 16, 8));
        boxBotoes.setStyle("-fx-background-color: #ffffff;");
        boxBotoes.setSpacing(10);
        paneButtons.getChildren().add(boxBotoes);


        //Fazer os Botoes
        Button botaoCalcular = new Button("Calcular");
        Button botaoLimpar = new Button("Limpar");
        Button botaoSair = new Button("Sair");



        //Adicionar os botoes a sua caixa
        boxBotoes.getChildren().addAll(botaoCalcular, botaoLimpar, botaoSair);


        //Criar a caixa de resultado
        VBox boxResultado = new VBox();
       boxResultado.setPrefHeight(300);
        //boxResultado.setStyle("-fx-background-color: #ff73e5");


        //Criar os componentes do BOXrESULTADOS
        Label labelResultado = new Label("Resultado");
        labelResultado.setPadding(new Insets(8, 16, 0, 8));
        labelResultado.setStyle("-fx-background-color: #fb82b4;");
        ListView listaTabuada = new ListView();
        listaTabuada.setPadding(new Insets(8, 8, 8, 8));

        //Adicionando
        boxResultado.getChildren().addAll(labelResultado, listaTabuada);

        //Adicionar componentes ao root
        root.getChildren().add(header);
        root.getChildren().add(gridFormulario);
        root.getChildren().add(boxResultado);
        root.getChildren().add(paneButtons);



// Colocamos a cena no palco
        stage.setScene(scene);






        stage.show();

        botaoCalcular.setOnAction(e -> {
            TabuadaUsuario tabuada = new TabuadaUsuario();


            tabuada.multiplicando =
                    Integer.parseInt(textFieldmultiplicando.getText());

            tabuada.multiplicadorInicial =
                Integer.parseInt(textFieldMenormultiplicador.getText());

            tabuada.multiplicadorFinal =
                    Integer.parseInt( textFieldMaiormultiplicador.getText());

           String[] resultado = tabuada.CalcularTabuada();
           listaTabuada.getItems().add(resultado);

            //gravar os dados da tabuada em arquivo
            Path arquivo = Path.of("C:\\Users\\25203692\\DS1T\\Tabuada");

            String dados = textFieldmultiplicando.getText() + ";" + textFieldMenormultiplicador.getText() + ";" + textFieldMaiormultiplicador.getText() + ";" + LocalDateTime.now() + "\n";

            try{
                Files.writeString(arquivo,"SenaiJandira\n", StandardOpenOption.APPEND);
            } catch (IOException erro){
                System.out.println(erro.getMessage());
            }

        });

        //limpar
        botaoLimpar.setOnAction(e -> {
            textFieldmultiplicando.clear();
            textFieldMenormultiplicador.clear();
            textFieldMaiormultiplicador.clear();
            listaTabuada.getItems().clear();
            textFieldMenormultiplicador.requestFocus();
        });


           //sair
        botaoSair.setOnAction(e -> {



        });
    }






}
