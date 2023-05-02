import { gitlabInstance, instance } from "./api";

// gitlab GET method by Project ID
export const requestGitlabInfo = async (hostUrl: string, projectID: string) => {
  return gitlabInstance.get(`${hostUrl}/api/v4/projects/${projectID}`);
};

// gitlab GET method by Project ID
export const requestGitlabBranch = async (
  hostUrl: string,
  projectID: string
) => {
  return gitlabInstance.get(
    `${hostUrl}/api/v4/projects/${projectID}/repository/branches`
  );
};

// framework 빌드 버전 조회
export const requestVersion = async (framework: string) => {
  return instance.get(`/project/buildVersion/${framework}`);
};

// 프로젝트 생성
export const requestCreateProject = async (params: IProject) => {
  return instance.post(`/project`, params);
};