package hello;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the estimates database table.
 * 
 */
@Entity
@Table(name="estimates")
@NamedQuery(name="Estimate.findAll", query="SELECT e FROM Estimate e")
public class Estimate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="estimate_id")
	private int estimateId;

	@Temporal(TemporalType.DATE)
	@Column(name="e_deadline")
	private Date eDeadline;

	@Column(name="e_quote")
	private double eQuote;

	//bi-directional many-to-one association to Contractor
	@ManyToOne
	@JoinColumn(name="e_contractor")
	private Contractor contractor;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="e_specaility")
	private Task task1;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="e_task")
	private Task task2;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="estimate1")
	private List<Task> tasks1;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="estimate2")
	private List<Task> tasks2;

	public Estimate() {
	}

	public int getEstimateId() {
		return this.estimateId;
	}

	public void setEstimateId(int estimateId) {
		this.estimateId = estimateId;
	}

	public Date getEDeadline() {
		return this.eDeadline;
	}

	public void setEDeadline(Date eDeadline) {
		this.eDeadline = eDeadline;
	}

	public double getEQuote() {
		return this.eQuote;
	}

	public void setEQuote(double eQuote) {
		this.eQuote = eQuote;
	}

	public Contractor getContractor() {
		return this.contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	public Task getTask1() {
		return this.task1;
	}

	public void setTask1(Task task1) {
		this.task1 = task1;
	}

	public Task getTask2() {
		return this.task2;
	}

	public void setTask2(Task task2) {
		this.task2 = task2;
	}

	public List<Task> getTasks1() {
		return this.tasks1;
	}

	public void setTasks1(List<Task> tasks1) {
		this.tasks1 = tasks1;
	}

	public Task addTasks1(Task tasks1) {
		getTasks1().add(tasks1);
		tasks1.setEstimate1(this);

		return tasks1;
	}

	public Task removeTasks1(Task tasks1) {
		getTasks1().remove(tasks1);
		tasks1.setEstimate1(null);

		return tasks1;
	}

	public List<Task> getTasks2() {
		return this.tasks2;
	}

	public void setTasks2(List<Task> tasks2) {
		this.tasks2 = tasks2;
	}

	public Task addTasks2(Task tasks2) {
		getTasks2().add(tasks2);
		tasks2.setEstimate2(this);

		return tasks2;
	}

	public Task removeTasks2(Task tasks2) {
		getTasks2().remove(tasks2);
		tasks2.setEstimate2(null);

		return tasks2;
	}

}