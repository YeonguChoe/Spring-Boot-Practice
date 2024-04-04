import React from 'react';
import {Link} from "react-router-dom";
import BasicLayout from "../Layouts/BasicLayout";

function About(props) {
    return (

        <BasicLayout>
            <div className={"text-2xl md:text-4xl sm:text-xl"}>
                About Page
            </div>
        </BasicLayout>
    );
}

export default About;