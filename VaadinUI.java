package hello;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

//import ContractorEditor hello;

@SpringUI
public class VaadinUI extends UI {


	private static final long serialVersionUID = 1L;

	private final ContractorRepository repo;

	private final ContractorEditor editor;

	final Grid<Contractor> grid;

	final TextField filter;

	private final Button addNewBtn;

	@Autowired
	public VaadinUI(ContractorRepository repo, ContractorEditor editor) {
		this.repo = repo;
		this.editor = editor;
		this.grid = new Grid<>(Contractor.class);
		this.filter = new TextField();
		this.addNewBtn = new Button("New Contractor", FontAwesome.PLUS);
	}

	@Override
	protected void init(VaadinRequest request) {
		// build layout
		HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
		VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
		setContent(mainLayout);

		grid.setHeight(300, Unit.PIXELS);


		grid.setColumns("contractorId", "CCompanyName"); // ************


		filter.setPlaceholder("Filter by Company name"); // ***********


		// Hook logic to components

		// Replace listing with filtered content when user changes filter
		filter.setValueChangeMode(ValueChangeMode.LAZY);
		filter.addValueChangeListener(e -> listContractors(e.getValue()));

		// Connect selected Contractor to editor or hide if none is selected
		grid.asSingleSelect().addValueChangeListener(e -> {
			editor.editContractor(e.getValue());
		});

		// Instantiate and edit new Contractor the new button is clicked
		addNewBtn.addClickListener(e -> editor.editContractor(new Contractor()));

		editor.setChangeHandler(() -> {
			editor.setVisible(false);
			listContractors(filter.getValue());
		});

		// Initialize listing
		listContractors(null);
	}

	// tag::listContractors[]
	void listContractors(String filterText) {
		if (StringUtils.isEmpty(filterText)) {
			
			grid.setItems((Collection<Contractor>) repo.findAll()); /// ***************************************rzd
		}
		else {

			grid.setItems(repo.findBycCompanyName(filterText));
			// *********************************


		}
	}
	// end::listContractors[]

}
