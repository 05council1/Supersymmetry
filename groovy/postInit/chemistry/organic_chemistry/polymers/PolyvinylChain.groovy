CSTR = recipemap('continuous_stirred_tank_reactor')
TBR = recipemap('trickle_bed_reactor')
BR = recipemap('batch_reactor')
POLYMERIZATION = recipemap('polymerization_tank')
MIXER = recipemap('mixer')
DRYER = recipemap('dryer')
AUTOCLAVE = recipemap('autoclave')
PHASE_SEPARATOR = recipemap('phase_separator')

// Vinyl Chloride

BR.recipeBuilder()
    .fluidInputs(fluid('mercury') * 1000)
    .fluidInputs(fluid('chlorine') * 2000)
    .outputs(metaitem('dustMercuryIiChloride') * 3)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

TBR.recipeBuilder()
    .notConsumable(metaitem('dustMercuryIiChloride'))
    .fluidInputs(fluid('acetylene') * 50)
    .fluidInputs(fluid('hydrogen_chloride') * 50)
    .fluidOutputs(fluid('vinyl_chloride') * 50)
    .duration(5)
    .EUt(30)
    .buildAndRegister()

CSTR.recipeBuilder()
    .fluidInputs(fluid('chlorine') * 100)
    .fluidInputs(fluid('ethylene') * 50)
    .fluidOutputs(fluid('vinyl_chloride') * 50)
    .fluidOutputs(fluid('hydrogen_chloride') * 50)
    .duration(5)
    .EUt(30)
    .buildAndRegister()

CSTR.recipeBuilder()
    .fluidInputs(fluid('ethylene') * 50)
    .fluidInputs(fluid('hydrogen_chloride') * 50)
    .fluidInputs(fluid('oxygen') * 50)
    .fluidOutputs(fluid('vinyl_chloride') * 50)
    .fluidOutputs(fluid('water') * 50)
    .duration(10)
    .EUt(30)
    .buildAndRegister()

CSTR.recipeBuilder()
    .fluidInputs(fluid('ethane') * 50)
    .fluidInputs(fluid('chlorine') * 200)
    .fluidOutputs(fluid('vinyl_chloride') * 50)
    .fluidOutputs(fluid('hydrogen_chloride') * 150)
    .duration(10)
    .EUt(30)
    .buildAndRegister()

CSTR.recipeBuilder()
    .fluidInputs(fluid('ethane') * 50)
    .fluidInputs(fluid('hydrogen_chloride') * 50)
    .fluidInputs(fluid('oxygen') * 100)
    .fluidOutputs(fluid('vinyl_chloride') * 50)
    .fluidOutputs(fluid('water') * 100)
    .duration(10)
    .EUt(30)
    .buildAndRegister()

// PVC

AUTOCLAVE.recipeBuilder()
    .fluidInputs(fluid('vinyl_chloride') * 1000)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('vinyl_chloride_suspension') * 2000)
    .duration(160)
    .EUt(30)
    .buildAndRegister()

POLYMERIZATION.recipeBuilder()
    .fluidInputs(fluid('vinyl_chloride_suspension') * 2000)
    .inputs(ore('dustTinyPotassiumPersulfate'))
    .fluidOutputs(fluid('polyvinyl_chloride_suspension') * 2000)
    .duration(300)
    .EUt(60)
    .buildAndRegister()

DRYER.recipeBuilder()
    .fluidInputs(fluid('polyvinyl_chloride_suspension') * 2000)
    .outputs(metaitem('dustPolyvinylChloride'))
    .fluidOutputs(fluid('water') * 1000)
    .duration(260)
    .EUt(30)
    .buildAndRegister()

// Polyvinyl Acetate

MIXER.recipeBuilder()
    .fluidInputs(fluid('vinyl_acetate') * 1000)
    .fluidInputs(fluid('methanol') * 1000)
    .fluidOutputs(fluid('vinyl_acetate_solution') * 1000)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

POLYMERIZATION.recipeBuilder()
    .fluidInputs(fluid('vinyl_acetate_solution') * 2000)
    .inputs(ore('dustTinyPotassiumPersulfate'))
    .fluidOutputs(fluid('polyvinyl_acetate_mixture') * 2000)
    .duration(150)
    .EUt(60)
    .buildAndRegister()

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('polyvinyl_acetate_mixture') * 2000)
    .outputs(metaitem('dustPolyvinylAcetate'))
    .fluidOutputs(fluid('methanol') * 1000)
    .duration(50)
    .buildAndRegister()

// Ethylene-vinyl acetate)

POLYMERIZATION.recipeBuilder()
    .fluidInputs(fluid('ethylene') * 1000)
    .fluidInputs(fluid('vinyl_acetate_solution') * 1000)
    .inputs(ore('dustTinyPotassiumPersulfate'))
    .fluidOutputs(fluid('ethylene_vinyl_acetate_mixture') * 2000)
    .duration(150)
    .EUt(60)
    .buildAndRegister()

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('ethylene_vinyl_acetate_mixture') * 2000)
    .outputs(metaitem('dustEthyleneVinylAcetate'))
    .fluidOutputs(fluid('methanol') * 1000)
    .duration(50)
    .buildAndRegister()
