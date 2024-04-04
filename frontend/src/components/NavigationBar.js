import React from 'react';
import {Link} from "react-router-dom";

function NavigationBar(props) {
    return (
        <nav className={"bg-red-500 py-5"}>
            <div className={"mx-auto flex justify-between items-center"}>
                {/*오른쪽 정렬된 로고*/}
                <Link className={"ml-20 text-3xl"} to={"/"}>SaleCar24</Link>

                {/*왼쪽 정렬된 버튼들*/}
                <div className={"mr-20 flex items-center space-x-4"}>
                    <Link to={"/"} className={"text-white hover:text-gray-500"}>Used Car</Link>
                    <Link to={"/about"} className={"text-white hover:text-gray-500"}>New Car</Link>
                    <Link to={"/todo/"} className={"text-white hover:text-gray-500"}>Todo</Link>
                </div>
            </div>
        </nav>
    );
}

export default NavigationBar;