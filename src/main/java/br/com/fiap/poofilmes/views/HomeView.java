package br.com.fiap.poofilmes.views;

import br.com.fiap.poofilmes.model.Filme;
import br.com.fiap.poofilmes.model.Producao;
import br.com.fiap.poofilmes.model.Serie;
import br.com.fiap.poofilmes.repository.ProducaoRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class HomeView extends VerticalLayout {

    private final ProducaoRepository producaoRepository;
    private final Dialog dialog = new Dialog();

    public HomeView(ProducaoRepository producaoRepository ) {

        dialog.setHeaderTitle("Cadastrar");

        VerticalLayout dialogLayout = new FormView();
        dialog.add(dialogLayout);

        Button saveButton = createSaveButton(dialog);
        Button cancelButton = new Button("Cancelar", e -> dialog.close());
        dialog.getFooter().add(cancelButton);
        dialog.getFooter().add(saveButton);

        Button button = new Button("Cadastrar", e -> dialog.open());
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.setIcon(VaadinIcon.PLUS.create());

        add(new H1("Senac Filmes"));
        add(dialog, button);
        add(new GridView(producaoRepository));

        this.producaoRepository = producaoRepository;
    }

    private Button createSaveButton(Dialog dialog) {
        Button button = new Button("Salvar", e -> {
            var form = (FormView) dialog.getChildren().findFirst().get();
            Producao producao;

            if (form.getRdTipo().getValue().equals("Filme")) {
                producao = new Filme();
                ((Filme) producao).setDiretor(form.getTxtDiretor().getValue());
            } else {
                producao = new Serie();
                ((Serie) producao).setTemporadas(form.getTxtTemporadas().getValue());
            }

            producao.setTitulo(form.getTxtTitulo().getValue());
            producao.setGenero(form.getTxtGenero().getValue());
            producao.setPoster(form.getTxtPoster().getValue());
            producao.setDataLancamento(form.getDtpDataLancamento().getValue());
            producao.setAvaliacao(form.getTxtAvaliacao().getValue());

            producaoRepository.create(producao);

            dialog.close();
        });
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        return button;
    }

}
