"use client";

import NavBarAluno from "@/components/NavBarAluno";
import NavBarEmpresa from "@/components/NavBarEmpresa";
import React, { useEffect, useState } from "react";

function Layout({ children }) {
  const [empresa, setEmpresa] = useState();

  useEffect(() => {
    fetch("http://localhost:8081/empresa-parceira/1")
      .then((response) => response.json())
      .then((data) => setEmpresa(data))
      .catch((error) => console.error(error));
  }, []);

  return (
    <>
      <NavBarEmpresa empresa={empresa} />
      <div className="h-[calc(100vh-96px)]">{children}</div>
    </>
  );
}

export default Layout;
