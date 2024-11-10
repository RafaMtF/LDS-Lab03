import { Button } from "@/components/ui/button";
import Image from "next/image";
import Link from "next/link";
import React from "react";

function NavBarEmpresa({ empresa }) {
  return (
    <>
      <div className="w-[100vw] h-24 bg-orange-400 px-8">
        <div className="flex items-center justify-between h-full">
          <div className="flex items-center">
            <Image src={empresa?.imagem} alt="Logo" width={50} height={50} />
            <h1 className="pl-4 text-4xl font-bold text-white">
              Seja bem vindo(a) {empresa?.nome}
            </h1>
          </div>
          <div className="flex items-center">
            <Button variant="create">
              <Link href={"/empresa-parceira/criar-vantagem"}>
                Criar Vantagem
              </Link>
            </Button>
          </div>
        </div>
      </div>
      <div className=""></div>
    </>
  );
}

export default NavBarEmpresa;
