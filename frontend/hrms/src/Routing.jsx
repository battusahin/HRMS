import JobPostings from "./pages/JobPostings";
import JobPosition from "./pages/JobPosition";
import Employer from "./pages/users/Employer";
import Candidate from "./pages/users/Candidate";
import Resumes from "./pages/Resumes";
import Dashboard from "./layouts/Dashboard";

export const routes = [

    {
        path: "/",
        exact: true,
        component: <Dashboard />,
        title: "Anasayfa",
        isHeaderElement: true,
    },
    {
        path: "/employers",
        exact: true,
        component: <Employer />,
        title: "Employer",
        isHeaderElement: true,
    },
    {
        path: "/candidates",
        exact: true,
        component: <Candidate />,
        title: "Candidate",
        isHeaderElement: true,
    },
    {
        path: "/jobPostings",
        exact: true,
        component: <JobPostings />,
        title: "JobPostings",
        isHeaderElement: true,
    },
    {
        path: "/jobs",
        exact: true,
        component: <JobPosition/>,
        title: "JobPosition",
        isHeaderElement: true,
    },
    {
        path: "/resumes",
        exact: true,
        component: <Resumes />,
        title: "Resume",
        isHeaderElement: true,
    }
];