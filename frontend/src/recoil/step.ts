import { atom } from "recoil";

export const chapterState = atom<number>({
  key: "chapter",

  default: 1,
});

export const stepState = atom<IStepItem[]>({
  key: "steps",

  default: [
    {
      number: 1,
      desc: "Project 설정 정보 입력",
      status: "now",
    },
    {
      number: 2,
      desc: "Item 정보 입력",
      status: "before",
    },
    {
      number: 3,
      desc: "Git 정보 입력",
      status: "before",
    },
    {
      number: 4,
      desc: "Nginx 설정 정보 입력",
      status: "before",
    },
  ],
});

const defaultProjectConfig: IProjectConfig = {
  hostUrl: "",
  repositoryUrl: "",
  projectId: "",
  projectName: "",
  description: "",
  imageUrl: "",
};

const defaultItem1: IItem = {
  itemName: "Front-end",
  portNumber1: "",
  portNumber2: "",
  branchName: "",
  secretToken: "생성 버튼을 눌러주세요.",
  targetFolder: "",
  frameworkType: "",
  buildVersion: "",
};

const defaultItem2: IItem = {
  itemName: "Back-end",
  portNumber1: "",
  portNumber2: "",
  branchName: "",
  secretToken: "생성 버튼을 눌러주세요.",
  targetFolder: "",
  frameworkType: "",
  buildVersion: "",
};

const defaultProxyPath: IProxyPath = {
  idx: 0,
  pathUrl: "",
  pathName: "",
};

const defaultNginxConfig: INginxConfig = {
  domainUrl: "",
  sslCertificate: "",
  sslCertificateKey: "",
  proxyPathList: [defaultProxyPath],
};

const defaultProject: IProject = {
  projectConfig: defaultProjectConfig,
  itemList: [defaultItem1, defaultItem2],
  nginxConfig: defaultNginxConfig,
};

// 스텝 1 프로젝트 정보
export const projectConfigState = atom<IProjectConfig>({
  key: "projectConfig",
  default: defaultProjectConfig,
});

// 스텝 2 아이템 리스트
export const itemListState = atom<IItem[]>({
  key: "itemList",
  default: defaultProject.itemList,
});

// 스텝 4 Nginx 정보
export const NginxState = atom<INginxConfig>({
  key: "nginx",
  default: defaultNginxConfig,
});
