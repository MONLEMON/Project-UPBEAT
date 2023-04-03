import "./Page3.css";
import React, { useState } from "react";

function Page3() {
  const [popup1, setPop1] = useState(false);
  const [ready, setReady] = useState(false);
  const handleClickOpen1 = () => {
    setPop1(!popup1);
  };

  const appearReady = () => {
    setReady(!ready);
  };
  const [popup2, setPop2] = useState(false);

  const handleClickOpen2 = () => {
    setPop2(!popup2);
  };

  const closePopup = () => {
    setPop1(false);
    setPop2(false);
  };

  const [name1, setName1] = useState("");
  const [name2, setName2] = useState("");

  return (
    <div className="app">
      <div className="bg3">
        <span>
          <button className="buttonPlayer1" onClick={handleClickOpen1}>
            PLAYER 1
          </button>
        </span>
        <span>
          <button className="buttonPlayer2" onClick={handleClickOpen2}>
            PLAYER 2
          </button>
        </span>

        <div>
          {ready ? (
            <div className="main">
              <div>
                <button className="setUp">
                  <span className="text10">Set Up</span>
                </button>
              </div>
              <button className="letGo">
                <a href="/page4" className="text9">
                  Let's Go
                </a>
              </button>
            </div>
          ) : (
            ""
          )}
        </div>

        <div>
          {popup1 ? (
            <div className="main">
              <div className="popup">
                <div className="popup-header">
                  <h1 className="fancy">PLAYER 1</h1>
                  <h1 onClick={closePopup}>X</h1>
                </div>
                <div>
                  <h5 className="text2">PLEASE TYPE YOUR NAME</h5>

                  <div className="form__group field">
                    <input
                      type="input"
                      className="form__field"
                      placeholder="Name"
                      name="name"
                      id="name"
                      required=""
                      onChange={(e) =>
                        setName1("✅" + e.target.value + " " + "has join")
                      }
                    />
                    <label htmlFor="name" className="form__label">
                      Name
                    </label>
                  </div>
                </div>
                <button className="button-78" onClick={closePopup}>
                  JOIN
                </button>
              </div>
            </div>
          ) : (
            ""
          )}
        </div>

        <div>
          {popup2 ? (
            <div className="main">
              <div className="popup2">
                <div className="popup-header">
                  <h1 className="player2text">PLAYER 2</h1>
                  <h1 onClick={closePopup} className="player2text">
                    X
                  </h1>
                </div>
                <div>
                  <h5 className="text2">PLEASE TYPE YOUR NAME</h5>

                  <div className="form__group field">
                    <input
                      type="input"
                      className="form__field"
                      placeholder="Name"
                      name="name"
                      id="name"
                      required=""
                      onChange={(e) =>
                        setName2("✅" + e.target.value + " " + "has join")
                      }
                    />
                    <label htmlFor="name" className="form__label">
                      Name
                    </label>
                  </div>
                </div>

                <button className="button-78" onClick={closePopup}>
                  <span onClick={appearReady}>JOIN</span>
                </button>
              </div>
            </div>
          ) : (
            ""
          )}
        </div>

        <div className="textset">
          <div className="text2">{name1}</div>
        </div>

        <div className="textset2">
          <div className="text2">{name2}</div>
        </div>
      </div>
    </div>
  );
}

export default Page3;
