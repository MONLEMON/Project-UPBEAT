import "./Page4.css";
import React from "react";

const sin60 = 2 / Math.sqrt(3);
const r = 100;

// const Hex = () => {
//   return <Hexagon className="hexagon" style={{ stroke: "orange" }} />;
// };

const Hex = (props) => {
  const { A, B, side = "", ...divProps } = props;

  return (
    <div
      {...divProps}
      className={`hex ${side}`}
      style={{
        //border: "1px solid #000",
        boxSizing: "border-box",
        height: r + "px",
        width: r + "px",
        ...props.style,
        position: "relative",
        borderRadius: "100%",
      }}
    >
      <div
        style={{
          borderTop: "1px solid #000",
          borderBottom: "1px solid #000",
          boxSizing: "border-box",
          width: r / Math.sqrt(3) + "px",
          height: "100%",
          margin: "0 auto",
          position: "absolute",
          top: 0,
          left: 0,
          right: 0,
          transform: "rotate(90deg)",
        }}
      />
      <div
        style={{
          borderTop: "1px solid #000",
          borderBottom: "1px solid #000",
          boxSizing: "border-box",
          width: r / Math.sqrt(3) + "px",
          height: "100%",
          margin: "0 auto",
          transform: "rotate(150deg)",
          transformOrigin: "center center",
          position: "absolute",
          top: 0,
          left: 0,
          right: 0,
        }}
      />
      <div
        style={{
          borderTop: "1px solid #000",
          borderBottom: "1px solid #000",
          boxSizing: "border-box",
          width: r / Math.sqrt(3) + "px",
          height: "100%",
          margin: "0 auto",
          transform: "rotate(210deg)",
          transformOrigin: "center center",
          position: "absolute",
          top: 0,
          left: 0,
          right: 0,
        }}
      />
    </div>
  );
};
function createBoard() {
  const rosLengthList = [10, 9, 10, 9, 10, 9, 10, 9, 10];

  return rosLengthList.map((length) => new Array(length).fill(0));
}

function put(board, rowIndex, cellIndex, side) {
  const newBoard = board.map((row) => [...row]);
  newBoard[rowIndex][cellIndex] = side;
  return newBoard;
}

function changeSide(side) {
  return side === "A" ? "B" : "A";
}

function reducer(state, action) {
  switch (action.type) {
    case "put":
      return {
        ...state,
        board: put(
          state.board,
          action.payload.rowIndex,
          action.payload.cellIndex,
          state.currentSide
        ),
        currentSide: changeSide(state.currentSide),
      };
    default:
      return state;
  }
}

function Page4() {
  const [state, dispatch] = React.useReducer(reducer, {
    board: createBoard(),
    currentSide: "A",
  });

  return (
    <div className="Hexgrid" style={{ width: "1000px", marginTop: "35px" }}>
      <div>
        {state.board.map((row, rowIndex) => {
          return (
            <div
              style={{
                marginTop: "-14px",
                display: "flex",
                justifyContent: "center",
              }}
            >
              {row.map((side, cellIndex) => (
                <Hex
                  side={side}
                  style={{ height: `${r}px`, width: `${r}px` }}
                  onClick={() =>
                    dispatch({
                      type: "put",
                      payload: { rowIndex, cellIndex },
                    })
                  }
                />
              ))}
            </div>
          );
        })}
      </div>

      <div className="bg99">
        <div className="ooo">
          <h4>name xxx</h4>
          <h4>time xx.xx</h4>
          <h4>Turn x</h4>
          <h4>budget xxxxx</h4>

          <textarea
            className="inputconstruc"
            name="message"
            rows="20"
            cols="66"
            placeholder="You constructor plan"
          />

          <button className="submitbutton">Submit</button>
        </div>
      </div>
    </div>
  );
}

export default Page4;
