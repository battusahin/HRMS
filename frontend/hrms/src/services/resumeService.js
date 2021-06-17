import axios from '../axios/axios';
export default class ResumService {
    getResumes() {
        return axios.get("/resumes/getall")
    }
    getByCandidateId(candidateId){
        return axios.get("/resumes/getByCandidateId?candidateId="+candidateId)
    }
}