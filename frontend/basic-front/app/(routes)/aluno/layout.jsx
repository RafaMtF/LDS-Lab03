"use client";

import NavBarAluno from "@/components/NavBarAluno";
import React, { useEffect, useState } from "react";

function Layout({ children }) {
  const [aluno, setAluno] = useState();

  useEffect(() => {
    fetch("http://localhost:8081/aluno/1")
      .then((response) => response.json())
      .then((data) => setAluno(data))
      .catch((error) => console.error(error));
  }, []);

  return (
    <>
      <NavBarAluno aluno={aluno} />
      <div className="h-[calc(100vh-96px)]">{children}</div>
    </>
  );
}

export default Layout;
