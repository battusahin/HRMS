import React, { useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";
import ResumeService from "../services/resumeService";
import { Card, Image, Table, Header, Button, Icon } from "semantic-ui-react";

export default function ResumeDetail() {
  //   let { id } = useParams(); //useParams() parametreleri obje olarak döndürür.

  //   const [resumes, setResumes] = useState([]);
  //   useEffect(() => {
  //     let resumeService = new ResumeService();
  //     resumeService
  //       .getByCandidateId(id)
  //       .then((result) => setResumes(result.data.data));
  //   }, [id]);

  let { id } = useParams(); //useParams() parametreleri obje olarak döndürür.

  const [resumes, setResumes] = useState([]);
  useEffect(() => {
      let resumeService = new ResumeService();
      resumeService
          .getByCandidateId(id)
          .then((result) => setResumes(result.data.data));
  }, [id]);

  return (
    <div>
        <Card.Group>
                <Card fluid>
                    <Card.Content>
                        <Image
                            floated="right"
                            size="mini"
                            src="/images/avatar/large/steve.jpg"
                        />
                        
                        <Card.Header>{resumes.candidateName}</Card.Header>
                        
                        <Card.Description>
                            Steve wants to add you to the group <strong>best friends</strong>
                        </Card.Description>
                    </Card.Content>
                    <Card.Content extra>
                        <div className="ui two buttons">
                            <Button basic color="green">
                                Approve
                            </Button>
                            <Button basic color="red">
                                Decline
                            </Button>
                        </div>
                    </Card.Content>
                </Card>
            </Card.Group>
    </div>
  );
}
