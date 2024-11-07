package br.com.fiap.poofilmes.views;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FormView extends VerticalLayout {

    private TextField txtTitulo = new TextField("Título");
    private TextField txtGenero = new TextField("Gênero");
    private TextField txtPoster = new TextField("Poster");
    private DatePicker dtpDataLancamento = new DatePicker("Data de Lançamento");
    private RadioButtonGroup<String> rdTipo = new RadioButtonGroup<>();
    private TextField txtDiretor = new TextField("Diretor");
    private IntegerField txtTemporadas = new IntegerField("Temporadas");
    private IntegerField txtAvaliacao = new IntegerField("Avaliação");

    public FormView() {

        rdTipo.setLabel("Tipo");
        rdTipo.setItems("Filme", "Série");
        rdTipo.setValue("Filme");

        txtTemporadas.setStepButtonsVisible(true);
        txtTemporadas.setMin(1);
        txtTemporadas.setValue(1);

        txtAvaliacao.setStep(1);
        txtAvaliacao.setMin(0);
        txtAvaliacao.setMax(5);
        txtAvaliacao.setStepButtonsVisible(true);
        txtAvaliacao.setValue(3);

        add(txtTitulo, txtGenero, txtPoster, dtpDataLancamento, rdTipo, txtDiretor, txtAvaliacao);

        rdTipo.addValueChangeListener(e -> {
            if (e.getValue().equals("Série")) {
                add(txtTemporadas);
                remove(txtDiretor);
            } else {
                add(txtDiretor);
                remove(txtTemporadas);
            }
        });
    }

}
