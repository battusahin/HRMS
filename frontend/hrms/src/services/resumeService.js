import axios from '../axios/axios';

export default class ResumService {
    getResumes() {
        return axios.get("/resumes/getall")
    }

    getByCandidateId(id){
        return axios.get("/resume/getByCandidateId?candidateId="+id)
    }
}