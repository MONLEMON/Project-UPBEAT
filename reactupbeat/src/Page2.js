import "./Page2.css";

function Page2() {
  return (
    <div className="app">
      <div className="bg2">
        <div className="Button01">
          <button className="startButton">
            <a href="/page3" className="textlinkstart">
              START
            </a>
          </button>

          <button className="tutorialButton">
            <a href="/" className="textlinktutorial">
              TUTORIAL
            </a>
          </button>

          <button className="exitButton">
            <a href="/" className="textlinkexit">
              EXIT
            </a>
          </button>
        </div>
      </div>
    </div>
  );
}

export default Page2;
