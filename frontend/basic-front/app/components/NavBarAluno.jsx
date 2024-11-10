import Image from "next/image";
import Link from "next/link";
import React from "react";

function NavBarAluno({ aluno }) {
  return (
    <>
    <div className="w-[100vw] h-24 bg-orange-400 px-8">
      <div className="flex items-center justify-between h-full">
        <div className="flex items-center">
          <h1 className="text-4xl font-bold text-white">{aluno?.nome}</h1>
        </div>
        <div className="flex items-center">
          <Link className="text-2xl text-white" href={`/transacao/extrato/aluno/${aluno?.id}`}>
            Saldo: {aluno?.saldo}
          </Link>
        </div>
      </div>
    </div>
    <div className="">

    </div>
    </>
  );
}

export default NavBarAluno;
