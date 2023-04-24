package org.a402.deployz.domain.project.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idx", nullable = false)
	private Long idx;
	@Column(name = "name", length = 20)
	private String name;
	@Column(name = "port_number1")
	private Long portNumber1;
	@Column(name = "port_number2")
	private Long portNumber2;
	@Column(name = "branchName", length = 50)
	private String branch_name;
	@Column(name = "target_folder_path", length = 100)
	private String targetFolderPath;
	@Column(name = "framework_type", length = 100)
	private String frameworkType;
	@Column(name = "framework_version", length = 50)
	private String frameworkVersion;
	@Column(name = "build_type", length = 20)
	private String buildType;
	@Column(name = "proxy_path", length = 50)
	private String proxyPath;
	@Column(name = "last_success_date")
	private LocalDateTime lastSuccessDate;
	@Column(name = "last_failure_date")
	private LocalDateTime lastFailureDate;
	@Column(name = "delete_flag")
	private boolean deleteFlag;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_idx")
	private Project project;
	@OneToMany(mappedBy = "item", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<BuildHistory> itemHistories;
	@OneToMany(mappedBy = "item", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<ItemState> itemStates;

	@Builder
	public Item(final Long idx, final String name, final Long portNumber1, final Long portNumber2,
		final String branch_name, final String targetFolderPath,
		final String frameworkType, final String frameworkVersion, final String buildType, final String proxyPath,
		final LocalDateTime lastSuccessDate,
		final LocalDateTime lastFailureDate, final boolean deleteFlag, final Project project,
		final List<BuildHistory> itemHistories,
		final List<ItemState> itemStates) {
		this.idx = idx;
		this.name = name;
		this.portNumber1 = portNumber1;
		this.portNumber2 = portNumber2;
		this.branch_name = branch_name;
		this.targetFolderPath = targetFolderPath;
		this.frameworkType = frameworkType;
		this.frameworkVersion = frameworkVersion;
		this.buildType = buildType;
		this.proxyPath = proxyPath;
		this.lastSuccessDate = lastSuccessDate;
		this.lastFailureDate = lastFailureDate;
		this.deleteFlag = deleteFlag;
		this.project = project;
		this.itemHistories = itemHistories;
		this.itemStates = itemStates;
	}

}
