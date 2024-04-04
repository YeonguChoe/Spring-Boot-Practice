import React from 'react';
import NavigationBar from "../components/NavigationBar";

function BasicLayout({children}) {
    return (
        // Fragment를 이용해서 1개의 JSX만 반환하게 만든다.
        <React.Fragment>

            <NavigationBar/>


            <div
                className="pl-5 pr-5 my-5 max-w-full w-full mx-auto flex flex-col space-y-1 md:flex-row md:space-x-1 md:space-y-0">

                {/*flex md:flex-row md:space-x-1*/}

                <aside className="bg-green-300 md:w-1/5 lg:w-1/4 px-5 flex py-5 hidden md:flex">

                    <h1 className="text-2xl md:text-4xl">Sidebar</h1>

                </aside>

                <main
                    className="bg-sky-300 md:w-4/5 lg:w-3/4 px-5 py-5">
                    {children}
                </main>

            </div>

        </React.Fragment>
    );
}

export default BasicLayout;