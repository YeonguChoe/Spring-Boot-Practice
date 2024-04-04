import {createSearchParams, useNavigate, useSearchParams} from "react-router-dom";

const getNum = (param, defaultValue) => {
    if (!param) {
        return defaultValue;
    }
    return parseInt(param)
}

/**
 * 커스텀훅: 여러개의 훅을 1개로 묶고 훅을 재사용하기 위해 사용한다.
 */

const useCustomMove = () => {
    // 이동하는 기능을 1개의 훅으로 묶어서 사용한다.
    const navigate = useNavigate();
    const [queryParams] = useSearchParams();

    // URL에서 쿼리 스트링을 추출 한다.
    const page = getNum(queryParams.get('page'), 1)
    const size = getNum(queryParams.get('size'), 10)

    const queryDefault = createSearchParams({page, size}).toString()

    const moveToList = () => {
        navigate(({pathname: `../list`, search: queryDefault}))
    }

    const moveToModify = (tno) => {
        navigate({
            pathname: `../modify/${tno}`,
            search: queryDefault
        })
    }

    return {moveToList, moveToModify, page, size}
}

export default useCustomMove;