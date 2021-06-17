import React, { useEffect, useState } from "react";
import { useParams, Link } from "react-router-dom";
import { Card, Button, Icon } from "semantic-ui-react";
import JobPostingService from "../services/jobPostingService";
import { Container, Row, Col } from "react-bootstrap";

export default function JobPostingDetail() {
  let { id } = useParams();
  const [jobPosting, setJobPosting] = useState([]);
  useEffect(() => {
    let jobPostingService = new JobPostingService();
    jobPostingService
      .getByJobPostingId(id)
      .then((result) => setJobPosting(result.data.data));
  }, [id]);

  return (
    <div>
      <Container>
        <Row>
          <Col md={4}>
            <Card.Group>
              <Card fluid>
                <Card.Content>
                  <Card.Header>{jobPosting.employer?.companyName}</Card.Header>

                  <Card.Description>
                    Telefon : {jobPosting.employer?.phoneNumber}
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
          </Col>
          <Col md={8}>
            <Card.Group>
              <Card fluid>
                <Card.Content>
                  <Card.Header>{jobPosting.jobPosition?.position}</Card.Header>

                  <Card.Description>
                    Lokasyon : {jobPosting.city?.name}
                  </Card.Description>
                </Card.Content>
                <Card.Content extra>
                  <div className="ui two buttons">
                    <Button basic color="green">
                      Approve
                    </Button>
                    <Button
                      animated
                      as={Link}
                      to={`/employers/${jobPosting.employer?.id}`}
                    >
                      <Button.Content visible>Detaylara Git</Button.Content>
                      <Button.Content hidden>
                        <Icon name="arrow right" />
                      </Button.Content>
                    </Button>
                  </div>
                </Card.Content>
              </Card>
            </Card.Group>
          </Col>
        </Row>
      </Container>
    </div>
  );
}
