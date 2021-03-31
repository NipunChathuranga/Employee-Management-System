import React, { Component } from "react";

class FooterComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {};
  }

  render() {
    return (
      //custom css are added in App.css file
      <div>
        <footer className="footer">
          <span className="text-muted">All Rights Reserved 2021 @NC</span>
        </footer>
      </div>
    );
  }
}

export default FooterComponent;
