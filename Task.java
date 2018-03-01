package hello;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tasks database table.
 * 
 */
@Entity
@Table(name="tasks")
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="task_id")
	private int taskId;

	@Temporal(TemporalType.DATE)
	@Column(name="t_acutal_complete_date")
	private Date tAcutalCompleteDate;

	@Column(name="t_acutal_price")
	private double tAcutalPrice;

	@Column(name="t_budget_price")
	private double tBudgetPrice;

	@Column(name="t_detail_description")
	private String tDetailDescription;

	@Temporal(TemporalType.DATE)
	@Column(name="t_goal_complete_date")
	private Date tGoalCompleteDate;

	@Column(name="t_notes")
	private String tNotes;

	//bi-directional many-to-one association to Estimate
	@OneToMany(mappedBy="task1")
	private List<Estimate> estimates1;

	//bi-directional many-to-one association to Estimate
	@OneToMany(mappedBy="task2")
	private List<Estimate> estimates2;

	//bi-directional many-to-one association to Estimate
	@ManyToOne
	@JoinColumn(name="t_estimate_selected")
	private Estimate estimate1;

	//bi-directional many-to-one association to Estimate
	@ManyToOne
	@JoinColumn(name="t_estimates")
	private Estimate estimate2;

	//bi-directional many-to-one association to Property
	@ManyToOne
	@JoinColumn(name="t_property")
	private Property property;

	//bi-directional many-to-one association to Speciality
	@ManyToOne
	@JoinColumn(name="t_specialty")
	private Speciality speciality;

	public Task() {
	}

	public int getTaskId() {
		return this.taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Date getTAcutalCompleteDate() {
		return this.tAcutalCompleteDate;
	}

	public void setTAcutalCompleteDate(Date tAcutalCompleteDate) {
		this.tAcutalCompleteDate = tAcutalCompleteDate;
	}

	public double getTAcutalPrice() {
		return this.tAcutalPrice;
	}

	public void setTAcutalPrice(double tAcutalPrice) {
		this.tAcutalPrice = tAcutalPrice;
	}

	public double getTBudgetPrice() {
		return this.tBudgetPrice;
	}

	public void setTBudgetPrice(double tBudgetPrice) {
		this.tBudgetPrice = tBudgetPrice;
	}

	public String getTDetailDescription() {
		return this.tDetailDescription;
	}

	public void setTDetailDescription(String tDetailDescription) {
		this.tDetailDescription = tDetailDescription;
	}

	public Date getTGoalCompleteDate() {
		return this.tGoalCompleteDate;
	}

	public void setTGoalCompleteDate(Date tGoalCompleteDate) {
		this.tGoalCompleteDate = tGoalCompleteDate;
	}

	public String getTNotes() {
		return this.tNotes;
	}

	public void setTNotes(String tNotes) {
		this.tNotes = tNotes;
	}

	public List<Estimate> getEstimates1() {
		return this.estimates1;
	}

	public void setEstimates1(List<Estimate> estimates1) {
		this.estimates1 = estimates1;
	}

	public Estimate addEstimates1(Estimate estimates1) {
		getEstimates1().add(estimates1);
		estimates1.setTask1(this);

		return estimates1;
	}

	public Estimate removeEstimates1(Estimate estimates1) {
		getEstimates1().remove(estimates1);
		estimates1.setTask1(null);

		return estimates1;
	}

	public List<Estimate> getEstimates2() {
		return this.estimates2;
	}

	public void setEstimates2(List<Estimate> estimates2) {
		this.estimates2 = estimates2;
	}

	public Estimate addEstimates2(Estimate estimates2) {
		getEstimates2().add(estimates2);
		estimates2.setTask2(this);

		return estimates2;
	}

	public Estimate removeEstimates2(Estimate estimates2) {
		getEstimates2().remove(estimates2);
		estimates2.setTask2(null);

		return estimates2;
	}

	public Estimate getEstimate1() {
		return this.estimate1;
	}

	public void setEstimate1(Estimate estimate1) {
		this.estimate1 = estimate1;
	}

	public Estimate getEstimate2() {
		return this.estimate2;
	}

	public void setEstimate2(Estimate estimate2) {
		this.estimate2 = estimate2;
	}

	public Property getProperty() {
		return this.property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Speciality getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

}