package hello;


import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringComponent
@UIScope
public class ContractorEditor extends VerticalLayout {
	private final ContractorRepository repository;

	private Contractor aContractor;


	TextField cCompanyName = new TextField("Company Name"); // ***

	// TextField contractorId = new TextField(" contractorId");


	/* Action buttons */
	Button save = new Button("Save", FontAwesome.SAVE);
	Button cancel = new Button("Cancel");
	Button delete = new Button("Delete", FontAwesome.TRASH_O);
	CssLayout actions = new CssLayout(save, cancel, delete);

	Binder<Contractor> binder = new Binder<>(Contractor.class);

	@Autowired
	public ContractorEditor(ContractorRepository repository) {
		this.repository = repository;

		addComponents(actions, cCompanyName, cCompanyName); // ****

		binder.bindInstanceFields(this);

		// Configure and style components
		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

		/* wire action buttons to save, delete and reset */

		save.addClickListener(e -> repository.save(aContractor));
		delete.addClickListener(e -> repository.delete(aContractor));
		cancel.addClickListener(e -> editContractor(aContractor));

		setVisible(false);
	}

	public interface ChangeHandler {

		void onChange();
	}

	public final void editContractor(Contractor c) {
		if (c == null) {
			setVisible(false);
			return;
		}
		final boolean persisted = c.getContractorId() != null; //////////////////
		if (persisted) {
			// Find fresh entity for editing
			aContractor = repository.findOne(c.getContractorId());
		} else {
			aContractor = c;
		}
		// cancel.setVisible(persisted);/***************lo comente y entonces fue cuando
		// aparecio la barra CANCEL en el local host!!!!!!!!!!!!!!!!!

		binder.setBean(aContractor);

		setVisible(true);

		/* A hack to ensure the whole form is visible */
		save.focus();
		// Select all text in firstName field automatically
		cCompanyName.selectAll();// ***


	}

	public void setChangeHandler(ChangeHandler h) {
		// ChangeHandler is notified when either save or delete
		// is clicked
		save.addClickListener(e -> h.onChange());
		delete.addClickListener(e -> h.onChange());
		// cancel.addClickListener(e -> h.onChange());// *****fue agrregado, se puede
		// eliminar, de todas manera no hace nada
	}

}