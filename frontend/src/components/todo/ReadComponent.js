import React, {useEffect, useState} from 'react';
import {getOne} from "../../api/todoAPI";
import useCustomMove from '../../hooks/useCustomMove';

// 기본 object
const initState = {
    tno: 0,
    title: '',
    content: '',
    dueDate: '',
    complete: false,
}

function ReadComponent({tno}) {
    /**
     * ajax로 백엔드와 통신하려면, useState와 useEffect를 사용한다.
     */

    const [todo, setTodo] = useState(initState);
    // useCustomMove에서 가져오기
    const {moveToList, moveToModify} = useCustomMove()

    useEffect(() => {
        getOne(tno).then(data => {
            setTodo(data);
        })
    }, [tno])

    return (
        <div className="border-2 border-sky-200 mt-10 m-2 p-4 ">
            {makeDiv('Tno', todo.tno)}
            {makeDiv('Content', todo.content)}
            {makeDiv('Title', todo.title)}
            {makeDiv('Due Date', todo.dueDate)}
            {makeDiv('Complete', todo.complete ? 'Completed' : 'Not Yet')}

            <div>
                {/*리스트 버튼*/}
                <button type={"button"} className={"rounded p-4 m-4 text-xl bg-blue-500"} onClick={() => moveToList()}>
                    List
                </button>
                {/* 수정으로 이동하는 버튼*/}
                <button type={"button"} className={"rounded p-4 m-4 text-xl bg-blue-500"}
                        onClick={() => moveToModify(todo.tno)}>
                    Modify
                </button>
            </div>
        </div>
    )
}

const makeDiv = (title, value) =>
    <div className="flex justify-center">
        <div className="relative mb-4 flex w-full flex-wrap items-stretch">
            <div className="w-1/5 p-6 text-right font-bold">{title}</div>
            <div className="w-4/5 p-6 rounded-r border border-solid shadow-md">
                {value}
            </div>
        </div>
    </div>

export default ReadComponent;