'use client'

import React from "react";
import BtnGoBack from "../../components/BtnGoBack";

export default function layout({ children }) {
  return (
    <div>
      {children}
      <BtnGoBack />
    </div>
  );
}
